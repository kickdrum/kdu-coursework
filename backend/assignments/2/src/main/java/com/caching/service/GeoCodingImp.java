package com.example.assignment2.service;

import com.example.assignment2.dto.GeoCodingRequestDTO;
import com.example.assignment2.dto.GeoCodingResponseDTO;
import com.example.assignment2.dto.ReverseGeoCodingRequestDTO;
import com.example.assignment2.dto.ReverseGeoCodingResponseDTO;
import com.example.assignment2.exception.customException.JsonResponseNodeException;
import com.example.assignment2.util.URIMaker;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Objects;

@Service
@Slf4j
public class GeoCodingImp implements GeoCoding{
    private  RestTemplate restTemplate;
    private  URIMaker uriMaker;
    private  CacheManager cacheManager;

    @Autowired
    GeoCodingImp(RestTemplate restTemplate,URIMaker uriMaker,CacheManager cacheManager){
        this.restTemplate=restTemplate;
        this.uriMaker=uriMaker;
        this.cacheManager = cacheManager;
    }

    /**
     * Retrieves geographic coordinates (latitude and longitude) for a given address.
     *
     * @param requestDTO The request containing the address to geocode.
     * @return A {@link GeoCodingResponseDTO} containing the latitude and longitude, or null if an error occurs.
     * @throws ResponseStatusException (400 BAD_REQUEST) if the address is null or empty.
     */
    public GeoCodingResponseDTO getGeoCoding(GeoCodingRequestDTO requestDTO){
        String address = requestDTO.getAddress();
        if (address == null || address.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"address is null");
        }

        GeoCodingResponseDTO cacheResponse = Objects.requireNonNull(cacheManager.getCache("geocoding")).get(address, GeoCodingResponseDTO.class);
        log.info("Cache search response:"+ cacheResponse);
        if(cacheResponse != null){
            return cacheResponse;
        }
        try{
           URI uri = uriMaker.requestURLBuilder(address);
            log.info(String.valueOf(uri));
            ResponseEntity<String> aPIresponse = restTemplate
                    .exchange(
                            uri,
                            HttpMethod.GET,new HttpEntity<>(null),String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(aPIresponse.getBody());
            if (root.has("error")) {
                throw new JsonResponseNodeException("error in Json Node");
            }
            JsonNode firstResult = root.path("data").path(0);
            if (firstResult.isMissingNode()) {
                throw new JsonResponseNodeException("missing node in Json");
            }
            String latitude = firstResult.path("latitude").asText();
            String longitude = firstResult.path("longitude").asText();

            GeoCodingResponseDTO responseDTO = GeoCodingResponseDTO.builder()
                    .latitude(latitude)
                    .longitude(longitude)
                    .build();
            if(!address.contains("goa")) {
                Objects.requireNonNull(cacheManager.getCache("geocoding")).put(address, responseDTO);
            }
            return responseDTO;

        } catch (Exception e){
            log.error("Something went wrong while getting value from positionstack api"+ e.getMessage());
        }
        return null;
    }
    /**
     * Retrieves an address for given geographic coordinates (latitude and longitude).
     *
     * @param requestDTO The request containing the latitude and longitude to reverse geocode.
     * @return A {@link ReverseGeoCodingResponseDTO} containing the address, or null if an error occurs.
     * @throws ResponseStatusException (400 BAD_REQUEST) if the latitude or longitude is invalid.
     */
    public ReverseGeoCodingResponseDTO getReverseGeoCoding(ReverseGeoCodingRequestDTO requestDTO){
        double latitude = requestDTO.getLatitude();
        double longitude = requestDTO.getLongitude();
        String cacheKey = latitude+ ","+longitude;
        log.info(cacheKey);
        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid latitude or longitude");
        }

        ReverseGeoCodingResponseDTO cacheResponse = Objects.requireNonNull(cacheManager.getCache("reverse-geocoding")).get(cacheKey,ReverseGeoCodingResponseDTO.class);
        log.info("Cache search response:"+ cacheResponse);
        if(cacheResponse != null){
            return cacheResponse;
        }
        try{
            URI uri = uriMaker.requestURLBuilder(latitude,longitude);
            log.debug(String.valueOf(uri));
            ResponseEntity<String> response = restTemplate
                    .exchange(
                            uri,
                            HttpMethod.GET,new HttpEntity<>(null),String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            if (root.has("error")) {
                throw new JsonResponseNodeException("error in Json Node");
            }
            JsonNode firstResult = root.path("data").path(0);
            if (firstResult.isMissingNode()) {
                throw new JsonResponseNodeException("missing node in Json");
            }
            String address = firstResult.path("label").asText();
            ReverseGeoCodingResponseDTO responseDTO =  ReverseGeoCodingResponseDTO.builder()
                    .address(address)
                    .build();
            Objects.requireNonNull(cacheManager.getCache("reverse-geocoding")).put(cacheKey,responseDTO);
            return responseDTO;
        } catch (Exception e){
            log.error("Something went wrong while getting value from positionstack api"+ e.getMessage());
        }
        return null;
    }
}
