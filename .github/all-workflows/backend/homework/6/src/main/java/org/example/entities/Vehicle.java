package org.example.entities;

public class Vehicle {
    private Speaker speaker;
    private Tyre tyre;
    private double price;

    public Vehicle(Speaker speaker, Tyre tyre, double price) {
        this.speaker = speaker;
        this.tyre = tyre;
        this.price = price;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
