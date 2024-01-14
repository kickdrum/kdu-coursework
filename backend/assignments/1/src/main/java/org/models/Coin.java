package org.models;

public class Coin {
    private int rank;
    private String symbol;
    private String name;
    private double price;
    private double volume;
    public Coin(int rank,String name,String symbol,double price,long volume){
        this.rank=rank;
        this.symbol=symbol;
        this.name=name;
        this.price=price;
        this.volume=volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    // Inside the Coin class
    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }

}
