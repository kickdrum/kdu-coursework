package org.example.Transactions;

import org.example.delay.HashFun;
import org.example.entities.UpdatePrice;
import org.example.globalObjects.GlobalData;

public class UpdatePriceTransaction extends Thread {
    private UpdatePrice updatePrice;
    private String transactionID;

    public UpdatePrice getUpdatePrice() {
        return updatePrice;
    }

    public UpdatePriceTransaction(UpdatePrice updatePrice) {
        this.updatePrice = updatePrice;
    }

    @Override
    public void run() {
        synchronized (this.updatePrice.getCoin()) {
            while (this.updatePrice.getCoin().getStatus().equals("not-available")) {
                try {
                    this.updatePrice.getCoin().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.updatePrice.getCoin().setStatus("not-available");
            this.transactionID = HashFun.getBlockHash();

            this.updatePrice.getCoin().setPrice(updatePrice.getPrice());
            this.updatePrice.getCoin().notifyAll();
            this.updatePrice.getCoin().setStatus("available");
        }
    }
}
