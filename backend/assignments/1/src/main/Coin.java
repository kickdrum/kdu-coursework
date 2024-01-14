package backend.assignment;

public class Coin {
    private int rank ;
    private String name;
    private String symbol;
    private double price;
    private long circulatingSupply;

    Coin(int rank,String name,String symbol,double price,long circulatingSupply){
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
    }
    // Getters
    public int getRank() {
        return rank;
    }
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
    public synchronized double getPrice() {
        return price;
    }
    public synchronized long getCirculatingSupply() {
        return circulatingSupply;
    }
    // Setters
    public void setRank(int rank) {
        this.rank = rank;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public synchronized void setPrice(double price) {
        this.price = price;
    }
    public synchronized void setCirculatingSupply(long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }
}
