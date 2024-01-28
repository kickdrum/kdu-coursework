package com.kdu.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kdu.caching.dto.GeoCodeResponseDto;
import com.kdu.caching.services.GeoCodingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for handling API endpoints related to geocoding and reverse geocoding.
 */
@RestController
public class GeoApi {


    @Autowired
    private GeoCodingService geoCodingService;

    @GetMapping("/geocoding")
    public GeoCodeResponseDto geocoding(@RequestParam String address) {
        return geoCodingService.getGeoCode(address);
    }
    @GetMapping("/reverse-geocoding")
    public String reverseGeocoding(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        return geoCodingService.getAddress(new ArrayList<>(List.of(latitude, longitude)));
    }
}

