package org.example.Bean;

public class Tyre {
    private String brand;
    private Double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
    public Tyre(){
        this.brand=brand;
        this.price=price;
    }
}
