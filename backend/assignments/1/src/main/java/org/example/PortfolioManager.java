package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import static org.example.Main.coins;
import static org.example.Main.slf4jLogger;

public class PortfolioManager {
    public static Map<String, Map<String, Integer>> portfolio = new HashMap<>();

    public static void updatePortfolio(String walletAddress, String coin, int quantity, Double price) {
        if (!portfolio.containsKey(walletAddress)) {
            portfolio.put(walletAddress, new HashMap<>());
        }

        Map<String, Integer> traderPortfolio = portfolio.get(walletAddress);

        if (!traderPortfolio.containsKey(coin)) {
            traderPortfolio.put(coin, 0);
        }

        int currentQuantity = traderPortfolio.get(coin);
        int updatedQuantity = currentQuantity + quantity;

        if (updatedQuantity >= 0) {
            traderPortfolio.put(coin, updatedQuantity);
            if (quantity > 0) {
                double transactionValue = quantity * price;
                double totalInvestment = traderPortfolio.getOrDefault("totalInvestment", 0);
                traderPortfolio.put("totalInvestment", (int) (totalInvestment + transactionValue));
            }
        } else {
            slf4jLogger.info("Error: Negative quantity in the portfolio");
        }
    }

    public static void getCoinDetails(String coinCode) {
        for (ArrayList<String> coin : coins) {
            if (coin.get(3).equals(coinCode)) {
                slf4jLogger.info("Coin Details for " + coinCode + ": " + coin);
                return;
            }
        }
        System.out.println("Coin with code " + coinCode + " not found.");
    }

    public static void displayTopCoins(int N) {
        coins.stream()
                .skip(1)
                .sorted((coin1, coin2) -> {
            try {
                double price1 = Double.parseDouble(coin1.get(4));
                double price2 = Double.parseDouble(coin2.get(4));
                return Double.compare(price2, price1); // Sort in descending order
            } catch (NumberFormatException e) {
                // Handle the case where parsing fails
                System.err.println("Error parsing prices for coins: " + coin1.get(3) + " or " + coin2.get(3));
                return 0;
            }
        })
                .limit(N)
                .forEach(coin -> slf4jLogger.info("Coin: " + coin.get(3) + ", Price: " + coin.get(4)));
    }
//
    public static void showTraderPortfolio(String walletAddress) {
        if (portfolio.containsKey(walletAddress)) {
            Map<String, Integer> traderPortfolio = portfolio.get(walletAddress);
            slf4jLogger.info("Trader Portfolio for " + walletAddress + ": " + traderPortfolio);
        } else {
            slf4jLogger.info("Trader not found with wallet address: " + walletAddress);
        }
    }

    public static void calculateTraderProfitLoss(String walletAddress) {
        if (portfolio.containsKey(walletAddress)) {
            Map<String, Integer> traderPortfolio = portfolio.get(walletAddress);
            int totalInvestment = traderPortfolio.getOrDefault("totalInvestment", 0);

            // Assuming the current value of the portfolio is the profit/loss
            int currentInvestment = traderPortfolio.getOrDefault("currentInvestment", 0);

            slf4jLogger.info("Total Profit/Loss for " + walletAddress + ": " +
                    (currentInvestment - totalInvestment));
        } else {
            slf4jLogger.info("Trader not found with wallet address: " + walletAddress);
        }
    }

    public static void displayTopBottomTraders(int N) {
        slf4jLogger.info("The top "+N+" Traders are:");
        portfolio.entrySet().stream()
                .sorted(Comparator.comparingDouble(entry ->
                        (double) entry.getValue().getOrDefault("totalInvestment", 0)))
                .limit(N)
                .forEach(entry -> slf4jLogger.info("Trader: " + entry.getKey() +
                        ", Profit/Loss: " + entry.getValue().getOrDefault("totalInvestment", 0)));

        slf4jLogger.info("The bottom "+N+" Traders are:");
        portfolio.entrySet().stream()
                .sorted(Comparator.comparingDouble(entry ->
                        -(double) entry.getValue().getOrDefault("totalInvestment", 0)))
                .limit(N)
                .forEach(entry -> slf4jLogger.info("Trader: " + entry.getKey() +
                        ", Profit/Loss: " + -entry.getValue().getOrDefault("totalInvestment", 0)));
    }
}
