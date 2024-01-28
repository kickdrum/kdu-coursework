package com.kdu.caching.repository;

import com.kdu.caching.services.GeoCodingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class CachedRepository {
    private static final Logger logger = LoggerFactory.getLogger(CachedRepository.class);
    CacheManager cacheManager;
    @Autowired
    public CachedRepository(){
        cacheManager = new CaffeineCacheManager();
    }

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

    public String getReverseGeocodingResult(String location) {
        Cache cache = cacheManager.getCache("reverse-geocoding");
        if (cache!=null) {
            if (cache.get(location) == null)
                return null;
            else return cache.get(location, String.class);
        }
        else return null;
    }

    public void putReverse(String key, String address){
        logger.info("Added to reverse cache");
        Cache cache = cacheManager.getCache("reverse-geocoding");
        if (cache!=null) {
            cache.put(key, address);
        }
    }

    public void putForward(String key, List<Double> coordinates){
        logger.info("Added to cache");
        Cache cache = cacheManager.getCache("geocoding");
        if (cache!=null) {
            cache.put(key, coordinates);
        }
    }

}
