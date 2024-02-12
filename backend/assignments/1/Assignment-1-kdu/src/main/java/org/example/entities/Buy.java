package org.example.entities;

import org.example.coins.Coin;
import org.example.globalObjects.GlobalData;
import org.json.simple.JSONObject;

public class Buy {
    private Coin coin;
    private long quantity;
    private String walletAddress;
    private String status;


    public Buy(JSONObject obj) {
        String coinSymbol = (String) obj.get("coin");
        this.coin = GlobalData.coinSymbolAndCoinObject.get(coinSymbol);
        this.quantity = (long) obj.get("quantity");
        this.walletAddress = (String) obj.get("wallet_address");
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

    @Override
    public String toString() {
        return "Buy{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

