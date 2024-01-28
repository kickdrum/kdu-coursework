package com.kdu.caching.repository;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Repository class to manage caches
 */
@Slf4j
@Repository
public class CachedRepository {
    private static final Logger logger = LoggerFactory.getLogger(CachedRepository.class);

    CaffeineCacheManager cacheManager;
    public CachedRepository(@Autowired CaffeineCacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    /**
     * Return forward Geocode result from cache
     * @param location address
     * @return coordinates
     */
    public List<Double> getGeocodingResult(String location) {
        Cache cache = cacheManager.getCache("geocoding");
        if (cache!=null) {
            if (cache.get(location) == null) {
                return Collections.emptyList();
            }
            else return cache.get(location, List.class);
        }
        else {
            return Collections.emptyList();
        }
    }

    /**
     * Return reverse geocode result from cache
     * @param location coordinates
     * @return address
     */
    public String getReverseGeocodingResult(String location) {
        Cache cache = cacheManager.getCache("reverse-geocoding");
        if (cache!=null) {
            if (cache.get(location) == null)
                return null;
            else return cache.get(location, String.class);
        }
        else return null;
    }

    /**
     * Add new address to reverse geocode cache
     * @param coordinates key
     * @param address value
     */
    public void putReverse(String coordinates, String address){
        logger.info("Added to reverse cache");
        Cache cache = cacheManager.getCache("reverse-geocoding");
        if (cache!=null) {
            cache.put(coordinates, address);
        }
    }

    /**
     * Add new latitude and longitude to forward geocode cache
     * @param address key
     * @param coordinates value
     */
    public void putForward(String address, List<Double> coordinates){
        logger.info("Added to cache");
        Cache cache = cacheManager.getCache("geocoding");
        if (cache!=null) {
            cache.put(address, coordinates);
        }
    }

}
