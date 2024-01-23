package com.example.demo.model;

import com.example.demo.logging.Logging;

/**
 * Model class representing a Speaker.
 */
public class Speaker {
    private String brand;
    private double price;

    // Constructor
    public Speaker() {
        Logging.getmsg().info("Speaker object successfully created!");
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
