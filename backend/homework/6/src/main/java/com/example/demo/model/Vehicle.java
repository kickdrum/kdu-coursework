package com.example.demo.model;

import com.example.demo.logging.Logging;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Model class representing a Vehicle.
 */
public class Vehicle {

    private Tyre tyre;
    private Speaker speaker;
    private double price;

    // Constructor
    @Autowired
    public Vehicle(Tyre tyre, Speaker speaker) {
        this.tyre = tyre;
        this.speaker = speaker;
        Logging.getmsg().info("Vehicle Object Created!");
    }

    // Getters and Setters
    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    // Override toString method to print details
    @Override
    public String toString() {
        return "Vehicle{" +
                "tyre=" + tyre +
                ", speaker=" + speaker +
                ", price=" + price +
                '}';
    }
}
