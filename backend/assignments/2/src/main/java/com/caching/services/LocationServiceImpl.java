package com.caching.services;

import com.caching.dto.LocationData;
import com.caching.dto.LocationResponse;
import com.caching.dto.ReverseGeocodingData;
import com.caching.dto.ReverseGeocodingResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Data
public class LocationServiceImpl implements LocationService {

    @Value("${api-key}")
    private String positionstackApiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("caffeineCacheManager")
    private CacheManager cacheManager;

    @Override
    @Cacheable(value = "geocoding", key = "#address", unless = "#address.contains('goa')")
    public List<LocationData> getGeoCode(String address) {
        log.info("Access key: " + positionstackApiKey);

        // Log cache hit or miss
        log.info("Checking cache for geocode data with address: " + address);

        // Spring will automatically handle cache hit or miss based on the annotation
        return fetchDataFromApiGeocode(address);
    }
    @CacheEvict(value = "geocoding", allEntries = true)
    public void evictAllCacheValues() {
        log.info("Evicting all entries from geocoding");
    }

    @Override
    @Cacheable(value = "reverse-geocoding", key = "{#latitude, #longitude}")
    public List<ReverseGeocodingData> getReverseGeoCode(Double latitude, Double longitude) {
        log.info("Access key: " + positionstackApiKey);

        log.info("Trying to fetch reverse geocoding data from API: " + latitude + ", longitude: " + longitude);

        return fetchDataFromApiReverseGeocoding(latitude, longitude);

    }
    @CacheEvict(value = "reverse-geocoding", key = "{#latitude, #longitude}")
    public void evictReverseGeocodeCacheEntry(Double latitude, Double longitude) {
        log.info("Evicting entry from reverse-geocoding for latitude: " + latitude + ", longitude: " + longitude);
    }


       private List<LocationData> fetchDataFromApiGeocode(String address) {
        log.info(positionstackApiKey);
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.positionstack.com")
                .path("/v1/forward")
                .queryParam("access_key", positionstackApiKey)
                .queryParam("query", address)
                .build();

        ResponseEntity<LocationResponse> responseEntity = restTemplate.getForEntity(uri.toUri(), LocationResponse.class);
        LocationResponse locationResponse = responseEntity.getBody();

        List<LocationData> modifiedDataList = locationResponse.getData().stream()
                .map(data -> {
                    LocationData modifiedData = new LocationData();
                    modifiedData.setLatitude(data.getLatitude());
                    modifiedData.setLongitude(data.getLongitude());
                    return modifiedData;
                })
                .collect(Collectors.toList());

        log.info("This is the geocoding response: " + modifiedDataList);

        // Check the condition before caching
        if (!address.contains("goa")) {
            Objects.requireNonNull(cacheManager.getCache("geocodeCache")).put(address, modifiedDataList);
            log.info("Fetch from API. Adding data to cache for address: " + address);
        }
        else{
            log.info("Fetch from API. Address is of Goa, so NOT adding to Cache " + address);

        }

        return modifiedDataList;
    }

    private List<ReverseGeocodingData> fetchDataFromApiReverseGeocoding(Double latitude, Double longitude) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.positionstack.com")
                .path("/v1/reverse")
                .queryParam("access_key", positionstackApiKey)
                .queryParam("query", String.format("%f,%f", latitude, longitude))
                .build();

        ResponseEntity<ReverseGeocodingResponse> responseEntity = restTemplate.getForEntity(uri.toUri(), ReverseGeocodingResponse.class);
        ReverseGeocodingResponse reverseGeocodingResponse = responseEntity.getBody();

        List<ReverseGeocodingData> modifiedDataList = reverseGeocodingResponse.getData().stream()
                .map(data -> {
                    ReverseGeocodingData modifiedData = new ReverseGeocodingData();
                    modifiedData.setLabel(data.getLabel());
                    return modifiedData;
                })
                .collect(Collectors.toList());

        log.info("This is the reverse geocoding response: " + modifiedDataList);

        return modifiedDataList;
    }
}
