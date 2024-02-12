package org.example.Transactions;

import org.example.delay.HashFun;
import org.example.entities.Sell;

import static org.example.globalObjects.GlobalData.tradersData;

public class SellCoinTransaction extends Thread {
    private Sell sell;
    private String transactionID;

    public Sell getSell() {
        return sell;
    }

    public SellCoinTransaction(Sell sell) {
        this.sell = sell;
    }

    public void run() {
        if((!tradersData.get(this.sell.getWalletAddress()).tradersCoin.containsKey(this.sell.getCoin().getSymbol())) ||
                ((tradersData.get(this.sell.getWalletAddress()).tradersCoin.get(this.sell.getCoin().getSymbol()).getCirculatingSupply()) < (this.sell.getQuantity()))) {
            this.sell.setTransactionStatus("not-allowed");
            return;
        }
        synchronized (this.sell.getCoin()) {
            while (this.sell.getCoin().getStatus().equals("not-available")) {
                try {
                    this.sell.getCoin().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.sell.getCoin().setStatus("not-available");
                this.transactionID = HashFun.getBlockHash();

                Double releasedRevenue = this.sell.getCoin().getPrice() * this.sell.getQuantity() + tradersData.get(this.sell.getWalletAddress()).getReleasedRevenue();
                tradersData.get(this.sell.getWalletAddress()).setReleasedRevenue(releasedRevenue);

                Long changeQuantity = tradersData.get(this.sell.getWalletAddress()).tradersCoin.get(this.sell.getCoin().getSymbol()).getCirculatingSupply();
                tradersData.get(this.sell.getWalletAddress()).tradersCoin.get(this.sell.getCoin().getSymbol()).setCirculatingSupply(changeQuantity - this.sell.getQuantity());

                this.sell.getCoin().setCirculatingSupply(sell.getCoin().getCirculatingSupply() + sell.getQuantity());
                this.sell.getCoin().notifyAll();
                this.sell.getCoin().setStatus("available");
                this.sell.getCoin().setTransactionStatus("completed");
            }
        }
    }
}
