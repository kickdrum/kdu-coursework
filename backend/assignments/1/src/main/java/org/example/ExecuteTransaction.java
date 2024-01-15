package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.collections4.IterableGet;

import java.util.concurrent.CountDownLatch;
import java.util.*;

import static java.lang.Integer.parseInt;
import static org.example.Main.slf4jLogger;
import static org.example.PortfolioManager.portfolio;

public class ExecuteTransaction implements Runnable{
    private String type;
    private JsonNode dataNode;
    private CountDownLatch latch;
    private static ArrayList<ArrayList<String>> coins; //for storing coins
    private static ArrayList<ArrayList<String>> traders; //for storing traders
    private static JsonNode jsonTransactions;
    public ExecuteTransaction(){}
    public ExecuteTransaction(String type, JsonNode dataNode, CountDownLatch latch, ArrayList<ArrayList<String>> coins, ArrayList<ArrayList<String>> traders) {
        this.type = type;
        this.dataNode = dataNode;
        this.latch = latch;
        this.coins=coins;
        this.traders=traders;

    }

    @Override
    public void run() {
        try {

            if ("BUY".equals(type)) {
                buyTransaction();
            } else if ("SELL".equals(type)) {
                sellTransaction();
            } else if ("UPDATE_PRICE".equals(type)) {
                updatePriceTransaction();
            } else if ("ADD_VOLUME".equals(type)) {
                addVolumeTransaction();
            } else {
                // Unknown transaction type
                slf4jLogger.info("Unknown transaction type: " + type);
            }
        } finally {
            // Count down the latch to signal completion
            latch.countDown();
        }
    }

    private void buyTransaction() {
        String coin = dataNode.get("coin").asText();
        int quantity = dataNode.get("quantity").asInt();
        String walletAddress = dataNode.get("wallet_address").asText();
        Double price= 0.0;

        boolean buyNotPossible=true;
        int cnt=0;
        for(int i=0;i<coins.size();i++){
            //cnt=i;
            String test=coins.get(i).get(3);
            if(coins.get(i).get(3).equals(coin)) {
                buyNotPossible=false;
                String test2=coins.get(i).get(5);
                Long test3= Long.parseLong(test2.trim());
                if (Long.parseLong(coins.get(i).get(5).trim())>= quantity) {
                    String newQuantity = Integer.toString((int) (Long.parseLong(coins.get(i).get(5).trim()) - quantity));
                    coins.get(i).set(5, newQuantity);

                    slf4jLogger.info("BUY transaction processed for coin: " + coin);

                    //Updating Traders Portfolio
                    String strPrice=coins.get(i).get(4);
                    price= Double.parseDouble(strPrice);
                    PortfolioManager.updatePortfolio(walletAddress, coin, quantity,price);
                    generateBlockHash();
                    slf4jLogger.info("BUY transaction processed and potfolio updated for coin: " + coin);
                }
                else{
                    //implement pending state
                    slf4jLogger.info("BUY transaction is Added to pending state for coin: " + coin);
                }
            }
        }
        if(buyNotPossible){
            slf4jLogger.info("BUY transaction is Can't possible as NO COIN Found with name: " + coin);
        }
    }

    private void sellTransaction() {
        String coin = dataNode.get("coin").asText();
        int quantity = dataNode.get("quantity").asInt();
        String walletAddress = dataNode.get("wallet_address").asText();
        Double price=0.0;

        //if trader quantity coins then subtract quantity from traders profile add to supply of coin, otherwise print Transaction not possible for this coin
        if (isSellPossible(walletAddress)) {

            // Check if the trader has enough coins in the portfolio
            Map<String, Integer> traderPortfolio = portfolio.get(walletAddress);
            if (traderPortfolio.containsKey(coin) && traderPortfolio.get(coin) >= quantity) {

                //Updating Traders Portfolio
                String strPrice="0.0";
                for(int i=0;i<coins.size();i++){
                    String test=coins.get(i).get(3);
                    if(coins.get(i).get(3).equals(coin)) {
                        strPrice=coins.get(i).get(4);
                    }
                }
                price= Double.parseDouble(strPrice);
                PortfolioManager.updatePortfolio(walletAddress, coin, -quantity, price); // Subtracting quantity for sell
                generateBlockHash();
                slf4jLogger.info("SELL transaction processed for coin: " + coin);
            } else {
                slf4jLogger.info("SELL transaction not possible for coin with this trader: " + coin);
            }
        } else {
            slf4jLogger.info("SELL Trader not found with wallet address: " + walletAddress);
        }
    }
    public static boolean isSellPossible(String walletAddress) {
        return portfolio.containsKey(walletAddress);
    }

    private void updatePriceTransaction() {
        String coin = dataNode.get("coin").asText();
        double price = dataNode.get("price").asDouble();

        boolean notFound=true;
        for(int i=0;i<coins.size();i++){
            if(coins.get(i).get(3).equals(coin)) {
                    String newPrice = String.valueOf(price);
                    coins.get(i).set(5, newPrice);
                    notFound=false;
                    slf4jLogger.info("Update Price transaction processed for coin: " + coin);
                    generateBlockHash();

            }
        }
        if(notFound)
            slf4jLogger.info("Update Price transaction not possible for coin: " + coin);
    }

    private void addVolumeTransaction() {
        String coin = dataNode.get("coin").asText();
        int volume = dataNode.get("volume").asInt();
        boolean notFound=true;
        for(int i=0;i<coins.size();i++){
            if(coins.get(i).get(3).equals(coin)) {
                String newVolume = String.valueOf(volume+ parseInt(coins.get(i).get(5)));
                coins.get(i).set(5, newVolume);
                notFound=false;
                generateBlockHash();
                slf4jLogger.info("Added Volume transaction processed for coin: " + coin);
            }
        }
        if(notFound)
            slf4jLogger.info("Add Volume transaction not possible for coin: " + coin);

    }

    private void generateBlockHash() {
        slf4jLogger.info("The Block Hash of the Coin is: "+ getBlockHash());
    }
    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
        /**
         * Introducing delay mimicking complex
         * calculation being performed.
         */
        for (double i = 0; i < 199999999; i++) {
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }
}
