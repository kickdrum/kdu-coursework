// TestController.java
package com.caching.controller;

import com.caching.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LocationService locationService;

//    @GetMapping("/evictGeocodeCache")
//    public ResponseEntity<String> evictGeocodeCache() {
//        locationService.evictGeocodeCache();
//        return ResponseEntity.ok("Geocode cache evicted.");
//    }
//
//    @GetMapping("/evictReverseGeocodeCache")
//    public ResponseEntity<String> evictReverseGeocodeCache() {
//        locationService.evictReverseGeocodeCache(0.0, 0.0); // Provide dummy latitude and longitude
//        return ResponseEntity.ok("Reverse geocode cache evicted.");
//    }
}
