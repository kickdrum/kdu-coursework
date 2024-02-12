package org.example.entities;

import org.example.coins.Coin;
import org.example.globalObjects.GlobalData;
import org.json.simple.JSONObject;

public class AddVolume {
    private long volume;
    private Coin coin;
    private String status;
    private String transactionStatus;

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public AddVolume(JSONObject obj) {
        this.volume = (long) obj.get("volume");
        this.coin = GlobalData.coinSymbolAndCoinObject.get((String) obj.get("coin"));
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddVolume{" +
                "volume=" + volume +
                ", coin=" + coin +
                ", status='" + status + '\'' +
                '}';
    }
}
