package com.example.demo.service;

import com.example.demo.model.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Service class responsible for generating Tyre objects.
 */
@Service
public class TyreService {
    private Random random = new Random();

    @Bean
    public Tyre generateTyre() {
        Tyre tyre = new Tyre();
        tyre.setBrand(generateRandomBrand());
        tyre.setPrice(calculateTyrePrice(tyre.getBrand()));
        return tyre;
    }

    private String generateRandomBrand() {
        // Generate a random brand: Bridgestone or MRF
        int randomInt = random.nextInt(2); // 0 or 1
        return (randomInt == 0) ? "Bridgestone" : "MRF";
    }

    private double calculateTyrePrice(String brand) {
        // Set the price based on the selected brand
        // Taking a random pricing for demo
        return (brand.equals("Bridgestone")) ? 150.0 : 120.0;
    }
}
