package jav.assignment.Entities;

import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;
import org.json.simple.JSONObject;

public class Sell {
    private Coin coin;
    private Long quantity;
    private String walletAddress;
    private String status = "available";
    private String transactionStatus;
    public Sell(JSONObject obj) {
        this.quantity = (Long) obj.get("quantity");
        this.coin = GlobalData.coinSymbolAndCoinObject.get((String) obj.get("coin"));
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}