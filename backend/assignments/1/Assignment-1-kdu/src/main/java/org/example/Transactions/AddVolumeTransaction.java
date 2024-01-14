package org.example.Transactions;

import org.example.delay.HashFun;
import org.example.entities.AddVolume;
import org.example.entities.UpdatePrice;

public class AddVolumeTransaction extends Thread {
    private AddVolume addVolume;
    private String transactionID;

    public AddVolume getUpdatePrice() {
        return addVolume;
    }

    public AddVolumeTransaction(AddVolume addVolume) {
        this.addVolume = addVolume;
    }

    @Override
    public void run() {
        synchronized (this.addVolume.getCoin()) {
            while (this.addVolume.getCoin().getStatus().equals("not-available")) {
                try {
                    this.addVolume.getCoin().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.addVolume.getCoin().setStatus("not-available");
            this.transactionID = HashFun.getBlockHash();

            this.addVolume.getCoin().setPrice((double) (addVolume.getCoin().getCirculatingSupply() + addVolume.getVolume()));
            this.addVolume.getCoin().notifyAll();
            this.addVolume.getCoin().setStatus("available");
            this.addVolume.setTransactionStatus("completed");
        }
    }
}
