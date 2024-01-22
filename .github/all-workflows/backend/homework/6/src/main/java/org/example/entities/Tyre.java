package org.example.entities;

public class Tyre {
    private String tyreBrand;
    private double tyrePrice;

    public Tyre(String brand, double price) {
        this.tyreBrand = brand;
        this.tyrePrice = price;
    }

    public String getTyreBrand() {
        return tyreBrand;
    }

    public void setTyreBrand(String tyreBrand) {
        this.tyreBrand = tyreBrand;
    }

    public double getTyrePrice() {
        return tyrePrice;
    }

    public void setTyrePrice(double tyrePrice) {
        this.tyrePrice = tyrePrice;
    }
}
