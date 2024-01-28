package com.caching.controller;

import com.caching.services.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/geocoding")
    public String getGeoCode(@RequestParam String address) {
        return convertListToJson(locationService.getGeoCode(address));
    }

    @GetMapping("/reverse-geocoding")
    public String getReverseGeoCode(@RequestParam Double latitude, @RequestParam Double longitude) {
        return convertListToJson(locationService.getReverseGeoCode(latitude, longitude));
    }

    private static String convertListToJson(List<?> list) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the list to JSON
            return objectMapper.writeValueAsString(list).replaceAll("\\[|\\]", "");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
            return null;
        }
    }
}
