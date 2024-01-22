package org.example.entities;

public class Speaker {
    private String speakerBrand;
    private double speakerPrice;

    public Speaker(String brand, double price) {
        this.speakerBrand = brand;
        this.speakerPrice = price;
    }

    public String getSpeakerBrand() {
        return speakerBrand;
    }

    public void setSpeakerBrand(String speakerBrand) {
        this.speakerBrand = speakerBrand;
    }

    public double getSpeakerPrice() {
        return speakerPrice;
    }

    public void setSpeakerPrice(double speakerPrice) {
        this.speakerPrice = speakerPrice;
    }
}
