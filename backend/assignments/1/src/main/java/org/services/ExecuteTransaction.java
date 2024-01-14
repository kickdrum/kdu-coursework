package org.services;

import org.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ExecuteTransaction implements Runnable {
    private static final Logger logger= LoggerFactory.getLogger(Main.class);

    private Transaction transaction;
    private List<Coin> coins;
    private List<Trader> traders;
    private CountDownLatch latch;

    /**
     *
     * @param transaction
     * @param coins
     * @param traders
     * @param latch
     */
    public ExecuteTransaction(Transaction transaction, List<Coin> coins, List<Trader> traders, CountDownLatch latch) {
        this.transaction = transaction;
        this.coins = coins;
        this.traders = traders;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            processTransaction();
        } finally {
            latch.countDown();
        }
    }

    private void processTransaction() {
        CryptoService cryptoService = new CryptoService(coins, traders, List.of(transaction));

        switch (transaction.getType()) {
            case BUY:
                cryptoService.processBuyTransaction(transaction);
                break;
            case SELL:
                cryptoService.processSellTransaction(transaction);
                break;
            case UPDATE_PRICE:
                cryptoService.processUpdatePriceTransaction(transaction);
                break;
            case ADD_VOLUME:
                cryptoService.processAddVolumeTransaction(transaction);
                break;
            default:
                logger.info("Unknown transaction type: " + transaction.getType());
        }
    }
}
