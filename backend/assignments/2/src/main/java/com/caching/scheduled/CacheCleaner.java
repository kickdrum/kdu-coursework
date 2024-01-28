package com.caching.scheduled;

import lombok.Data;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
public class CacheCleaner {


    private CacheManager cacheManager;

    @Scheduled(fixedRate = 3600000) // Run every hour, adjust as needed
    public void cleanCache() {
        cleanCache("geocoding");
        cleanCache("reverse-geocoding");
    }

    private void cleanCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            // Use getNativeCache() method instead of direct casting
            Object nativeCache = cache.getNativeCache();

            if (nativeCache instanceof com.github.benmanes.caffeine.cache.Cache) {
                // Iterate over cache keys and evict entries based on your conditions
                for (Object key : Objects.requireNonNull(((com.github.benmanes.caffeine.cache.Cache<?, ?>) nativeCache).asMap().keySet())) {
                    cache.evict(key);
                }
            }
        }
    }
}
