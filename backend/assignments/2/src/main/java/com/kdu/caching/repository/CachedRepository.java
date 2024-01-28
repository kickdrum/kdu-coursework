package com.kdu.caching.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CachedRepository {
    CacheManager cacheManager;
    @Autowired
    public CachedRepository(){
        cacheManager = new CaffeineCacheManager();
    }

    public List<Double> getGeocodingResult(String location) {
        if (cacheManager.getCache("geocoding").get(location)==null)
            return null;
        else return cacheManager.getCache("geocoding").get(location,List.class);
    }

    public String getReverseGeocodingResult(String location) {
        if (cacheManager.getCache("reverse-geocoding").get(location)==null)
            return null;
        else return cacheManager.getCache("reverse-geocoding").get(location,String.class);
    }

    public void putReverse(String key, String address){
        cacheManager.getCache("reverse-geocoding").put(key,address);
        System.out.println("created cache");
    }

    public void putForward(String key, List<Double> coordinates){
        cacheManager.getCache("geocoding").put(key,coordinates);
        System.out.println("created cache");
    }

}
