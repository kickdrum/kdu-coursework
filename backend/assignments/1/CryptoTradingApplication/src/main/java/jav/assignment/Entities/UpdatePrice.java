package jav.assignment.Entities;

import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;
import org.json.simple.JSONObject;

public class UpdatePrice {
    private Coin coin;
    private long quantity;
    private String walletAddress;
    private String status;
    private Double price;

    public UpdatePrice(JSONObject obj) {
        this.price = (Double) obj.get("price");
        this.coin = GlobalData.coinSymbolAndCoinObject.get((String) obj.get("coin"));
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdatePrice{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
