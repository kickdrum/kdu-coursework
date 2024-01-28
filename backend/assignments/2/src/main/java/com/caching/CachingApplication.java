package com.caching;

import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.caching")
@EnableCaching
@EnableScheduling
public class CachingApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(CachingApplication.class).profiles("dev").run(args);
	}
}
