package com.example.demo.service;

import com.example.demo.model.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Service class responsible for generating Speaker objects.
 */
@Configuration
public class SpeakerService {
    private Random random = new Random();

    @Bean
    public Speaker generateSpeaker() {
        Speaker speaker = new Speaker();
        speaker.setBrand(generateRandomBrand());
        speaker.setPrice(calculateSpeakerPrice(speaker.getBrand()));
        return speaker;
    }

    private String generateRandomBrand() {
        // Generate random brand: Sony or Bose
        int randomInt = random.nextInt(2); // 0 or 1
        return (randomInt == 0) ? "Sony" : "Bose";
    }

    private double calculateSpeakerPrice(String brand) {
        return (brand.equals("Sony")) ? 200 : 150;
    }
}
