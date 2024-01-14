package jav.assignment.Transactions;

import jav.assignment.BlockHash.BlockHash;
import jav.assignment.Entities.IncreaseVolume;

import java.util.concurrent.CountDownLatch;

public class IncreaseVolumeTransaction extends Thread {
    private IncreaseVolume addVolume;
    private String transactionID;
    private CountDownLatch latch;

    public IncreaseVolumeTransaction(IncreaseVolume addVolume, CountDownLatch latch) {
        this.addVolume = addVolume;
        this.latch = latch;
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
            this.transactionID = BlockHash.getBlockHash();

            // Assuming the following line is to update the circulating supply with the added volume
            this.addVolume.getCoin().setCirculatingSupply(addVolume.getCoin().getCirculatingSupply() + addVolume.getVolume());

            this.addVolume.getCoin().notifyAll();
            this.addVolume.getCoin().setStatus("available");
            this.addVolume.setTransactionStatus("completed");

            // Count down the latch after the completion of the transaction
            latch.countDown();
        }
    }
}
