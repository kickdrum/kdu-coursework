package com.kdu.caching.services;

import com.kdu.caching.utils.ApiUtils;
import com.kdu.caching.dto.GeoCodeResponseDto;
import com.kdu.caching.repository.CachedRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Service
public class GeoCodingService {
    private static final Logger logger = LoggerFactory.getLogger(GeoCodingService.class);

    @Value("${api-key}")
    private String apiKey;
    private final CachedRepository cache;

    public GeoCodingService (@Autowired CachedRepository cache){
        this.cache = cache;
    }

    /**
     * Service layer function for reverse GeoCoding.
     * Checks the cache, makes ap call, updates the cache if not present
     * @param coordinates latitude and longitude
     * @return address
     */
    public String getAddress(List<Double> coordinates){
        String address = cache.getReverseGeocodingResult(coordinates.toString());
        if (address==null){
            logger.info("{} not cached calling 3rd party API", coordinates);
            address = positionStackReverse(coordinates);
            cache.putReverse(coordinates.toString(),address);
        }
        return address;
    }


    /**
     * Service layer function for forward GeoCoding.
     * Checks the cache, makes ap call, updates the cache if not present
     * @param address address
     * @return latitude and longitude in a dto
     */
    public GeoCodeResponseDto getGeoCode(String address){
        List<Double> coordinates = cache.getGeocodingResult(address);
        if (coordinates==null || coordinates.isEmpty()){
            logger.info("{} not cached calling 3rd party API", address);
            Pair<Boolean,List<Double>> goaCheckAndCoordinate = positionStackForward(address);
            assert goaCheckAndCoordinate != null;
            coordinates = goaCheckAndCoordinate.getRight();
            if (Boolean.FALSE
                    .equals(goaCheckAndCoordinate.getLeft()))
                cache.putForward(address,coordinates);
        }
        return new GeoCodeResponseDto(coordinates.get(0),coordinates.get(1), HttpStatus.OK.value());
    }

    /**
     * Helper function for getAddress, uses utils to get data from position stack
     * @param coordinates latitude and longitude
     * @return address
     */
    private String positionStackReverse(List<Double> coordinates){
        String apiUrl = "http://api.positionstack.com/v1/reverse?access_key=" + apiKey + "&query=" + coordinates.get(0) + "," + coordinates.get(1);
        String response;
        try {
            response = ApiUtils.makeRequest(apiUrl);
        }catch (Exception e){
            logger.error("Error while making get request {}",e.getMessage());
            return null;
        }
        if (response!=null) {
            JSONObject jsonResponse = ApiUtils.getJsonResponse(response);
            return jsonResponse.getString("label");
        }
        else
            return null;
    }

    /**
     * Helper function for getGeoCode, uses utils to get data from position stack
     * @param address address
     * @return latitude and longitude
     */
    private Pair<Boolean, List<Double>> positionStackForward(String address){
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
        String apiUrl = "http://api.positionstack.com/v1/forward?access_key=" + apiKey + "&query=" + encodedAddress;
        String response;
        try {
            response = ApiUtils.makeRequest(apiUrl);
        }catch (Exception e){

            logger.error("Error while making get request {}",e.getMessage());
            return null;
        }
        if (response!=null) {
            JSONObject jsonResponse = ApiUtils.getJsonResponse(response);

            List<Double> coordinates = List.of(jsonResponse.getDouble("latitude"), jsonResponse.getDouble("longitude"));
            return Pair.of(jsonResponse.getString("region").toLowerCase().contains("goa"),coordinates);
        }
        else
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
