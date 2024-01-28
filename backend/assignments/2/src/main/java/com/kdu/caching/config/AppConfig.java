package com.kdu.caching.config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kdu.caching")
@EnableCaching
public class AppConfig {
}
