package org.services;
import org.models.*;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CryptoService {
    private static final int MAX_VOLUME=1000000;
    private static final Object lock=new Object();
    private List<Coin> coins;
    private List<Trader> traders;
    private List<Transaction> transactions;
    public CryptoService(List<Coin> coins, List<Trader> traders, List<Transaction> transactions){
        this.coins=coins;
        this.traders=traders;
        this.transactions=transactions;
    }
    public void processTransactionsInThreadPool(){
        ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatch latch=new CountDownLatch(transactions.size());
        for(Transaction transaction:transactions){
            executorService.submit(()->processTransactions(transaction));
        }
        executorService.shutdown();
    }

    /**
     *
     * @param transaction
     */
    public void processTransactions(Transaction transaction){
        switch (transaction.getType()){
            case BUY : processBuyTransaction(transaction);
                        break;
            case SELL:processSellTransaction(transaction);
                        break;
            case UPDATE_PRICE:processUpdatePriceTransaction(transaction);
                        break;
            case ADD_VOLUME:processAddVolumeTransaction(transaction);
                        break;
        }
    }

    /**
     *
     * @param transaction
     */
    public void processBuyTransaction(Transaction transaction){
        synchronized (lock){
            Coin coin=getCoinBySymbol(transaction.getCoinSymbol());
            if (coin != null){
                if (coin.getVolume()>=transaction.getAmount()){
                    coin.setVolume(coin.getVolume()-transaction.getAmount());
                    transaction.setTransactionHash(transaction.getBlockHash());
                }
                else
                    transaction.markAsPending();
            }
        }
    }

    /**
     *
     * @param transaction
     */
    public void processSellTransaction(Transaction transaction){
        synchronized (lock){
            Coin coin = getCoinBySymbol(transaction.getCoinSymbol());
            if(coin!=null){
                coin.setVolume(coin.getVolume()+transaction.getAmount());
                transaction.setTransactionHash(transaction.getBlockHash());
            }
        }
    }

    /**
     *
     * @param symbol
     * @return
     */
    public Coin getCoinBySymbol(String symbol){
        return coins.stream()
                .filter(coin -> coin.getSymbol().equalsIgnoreCase(symbol))
                .findFirst()
                .orElse(null);
    }

    /**
     *
     * @param transaction
     */
    public void processUpdatePriceTransaction(Transaction transaction){
        synchronized (lock){
            Coin coin = getCoinBySymbol(transaction.getCoinSymbol());
            if(coin!=null){
                coin.setPrice(transaction.getAmount());
                transaction.setTransactionHash(transaction.getBlockHash());
            }
        }
    }

    /**
     *
     * @param transaction
     */
    public void processAddVolumeTransaction(Transaction transaction){
        synchronized (lock) {
            Coin coin = getCoinBySymbol(transaction.getCoinSymbol());
            if (coin != null) {
                if(coin.getVolume()+transaction.getAmount()<=MAX_VOLUME){
                    coin.setVolume(coin.getVolume()+transaction.getAmount());
                    transaction.setTransactionHash(transaction.getBlockHash());
                }
            }
        }
    }

    /**Helper function a: Given the name or code of a coin, retrieve all its details.
     *
     * @param nameOrCode
     * @return
     */
    public Optional<Coin> getCoinDetails(String nameOrCode) {
        return coins.stream()
                .filter(coin -> coin.getName().equalsIgnoreCase(nameOrCode) || coin.getSymbol().equalsIgnoreCase(nameOrCode))
                .findFirst();
    }

    /**Helper function b: Display top N coins in the market based on price.
     *
     * @param topN
     * @return
     */
    public List<Coin> getTopCoinsByPrice(int topN) {
        return coins.stream()
                .sorted(Comparator.comparingDouble(Coin::getPrice).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    /**Helper function c: For a given trader, show his portfolio.
     *
     * @param traderId
     * @return
     */
    public Map<String, Double> getTraderPortfolio(String traderId) {
        return transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.BUY && transaction.getTraderId().equals(traderId))
                .collect(Collectors.groupingBy(Transaction::getCoin, Collectors.summingDouble(Transaction::getQuantity)));
    }

    /**Helper function d: For a given trader, display the total profit or loss they have made trading in the crypto market.
     *
     * @param traderId
     * @return
     */
    public double getTraderProfitOrLoss(String traderId) {
        List<Transaction> traderTransactions = transactions.stream()
                .filter(transaction -> transaction.getTraderId().equals(traderId))
                .toList();

        return traderTransactions.stream()
                .mapToDouble(transaction -> {
                    Coin coin = getCoinDetails(transaction.getCoin()).orElse(null);
                    if (coin != null) {
                        double transactionValue = transaction.getQuantity() * coin.getPrice();
                        return (transaction.getType() == TransactionType.BUY) ? -transactionValue : transactionValue;
                    }
                    return 0.0;
                })
                .sum();
    }

    /**hHelper function e: Show top 5 and bottom 5 traders based on their profit/loss.
     *
     * @param topN
     * @return
     */
    public List<String> getTopAndBottomTraders(int topN) {
        return traders.stream()
                .sorted(Comparator.comparingDouble(trader -> getTraderProfitOrLoss(trader.getId())))
                .limit(topN)
                .map(Trader::getId)
                .collect(Collectors.toList());
    }
}