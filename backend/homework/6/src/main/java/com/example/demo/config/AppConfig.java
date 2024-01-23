package com.example.demo.config;

import com.example.demo.service.SpeakerService;
import com.example.demo.service.TyreService;
import com.example.demo.service.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class responsible for defining beans and component scanning.
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {

    @Bean
    public TyreService tyreService() {
        return new TyreService();
    }

    @Bean
    public SpeakerService speakerService() {
        return new SpeakerService();
    }

    @Bean
    public VehicleService vehicleService(TyreService tyreService, SpeakerService speakerService) {
        return new VehicleService(tyreService, speakerService);
    }
}
