package org.example.Bean;

public class Speaker {
    private String brand;
    private Double price;

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }
    public Speaker(){
        this.brand=brand;
        this.price=price;
    }
}