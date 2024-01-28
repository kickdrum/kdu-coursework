package com.kdu.caching.services;

import com.kdu.caching.api_utils.ApiUtils;
import com.kdu.caching.dto.GeoCodeResponseDto;
import com.kdu.caching.repository.CachedRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeoCodingService {
    @Value("${api-key}")
    private String apiKey;
    private final CachedRepository cache;
    @Autowired
    public GeoCodingService (){
        cache = new CachedRepository();
    }
    public String getAddress(List<Double> coordinates){
        String address = cache.getReverseGeocodingResult(coordinates.toString());
        if (address==null){
            System.out.println("Not Cached");
            address = positionStackReverse(coordinates);
            cache.putReverse(coordinates.toString(),address);
        }
        System.out.println(address);
        return address;
    }


    public GeoCodeResponseDto getGeoCode(String address){
        List<Double> coordinates = cache.getGeocodingResult(address);
        if (coordinates==null){
            System.out.println("Not Cached");
            coordinates = positionStackForward(address);
            cache.putForward(address,coordinates);
        }
        System.out.println(coordinates);
        return new GeoCodeResponseDto(coordinates.get(0),coordinates.get(1), HttpStatus.OK.value());
    }

    private String positionStackReverse(List<Double> coordinates){
        String apiUrl = "http://api.positionstack.com/v1/reverse?access_key=" + apiKey + "&query=" + coordinates.get(0) + "," + coordinates.get(1);
        String response;
        try {
            response = ApiUtils.makeRequest(apiUrl);
        }catch (Exception e){
            return "Error";
        }
        if (response!=null) {
            JSONObject JsonResponse = ApiUtils.getJsonResponse(response);
            return JsonResponse.getString("label");
        }
        else
            return "Error";
    }

    private List<Double> positionStackForward(String address){
        String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
        String apiUrl = "http://api.positionstack.com/v1/forward?access_key=" + apiKey + "&query=" + encodedAddress;
        String response;
        try {
            response = ApiUtils.makeRequest(apiUrl);
        }catch (Exception e){
            System.out.println("Exception");
            return null;
        }
        if (response!=null) {
            JSONObject JsonResponse = ApiUtils.getJsonResponse(response);
            return new ArrayList<Double>(List.of(new Double[]{JsonResponse.getDouble("latitude"), JsonResponse.getDouble("longitude")}));
        }
        else
            return null;
    }

}
