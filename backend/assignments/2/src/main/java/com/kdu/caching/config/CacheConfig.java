package com.kdu.caching.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * Configuration class for setting up CachedRepository with Caffeine.
 */
@Configuration
@EnableCaching
public class CacheConfig {
    /**
     * Creating the cache manager bean using LRU policy with both caches
     * @return cache manager bean
     */
    @Bean
    public CaffeineCacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeineConfig());
        cacheManager.setCacheNames(asList("geocoding", "reverse-geocoding"));
        return cacheManager;
    }

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                .maximumSize(50)
                .expireAfterAccess(60, TimeUnit.MINUTES);
    }
}