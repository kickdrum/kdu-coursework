package com.example.demo.model;

import com.example.demo.logging.Logging;

/**
 * Model class representing a Tyre.
 */
public class Tyre {

    private String brand;
    private double price;

    // Constructor
    public Tyre() {
        Logging.getmsg().info("Tyre object successfully created! ");
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
