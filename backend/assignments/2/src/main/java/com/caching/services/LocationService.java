package com.caching.services;

import com.caching.dto.LocationData;
import com.caching.dto.ReverseGeocodingData;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface LocationService {
    @Cacheable(value = "geocoding", key = "#address")
    List<LocationData> getGeoCode(String address);

    @Cacheable(value = "reverse-geocoding", key = "{#latitude, #longitude}")
    List<ReverseGeocodingData> getReverseGeoCode(Double latitude, Double longitude);

}
