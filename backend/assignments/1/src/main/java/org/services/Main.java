// Main.java
package org.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.*;
import org.services.CryptoService;
import org.services.ExecuteTransaction;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger= LoggerFactory.getLogger(Main.class);
    private static List<Coin> coins;
    private static List<Trader> traders;
    private static List<Transaction> transactions;

    public static void main(String[] args) {
        JsonNode jsonTransactions = loadJsonNodeFromJSON("src/main/resources/small_transaction.json");
        CountDownLatch latch = new CountDownLatch(jsonTransactions.size());

        executeTransactions(jsonTransactions, latch);
        displayMenu();

    }

    /**
     *
     * @param jsonTransactions
     * @param latch
     */
    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
        try {
             CryptoApplication cryptoService=new CryptoApplication();
             coins = cryptoService.loadCoinsFromCSV("src/main/resources/coins.csv");
             traders=cryptoService.loadTraderFromCSV("src/main/resources/traders.csv");
             transactions = cryptoService.loadTransactionsFromJSON("src/main/resources/small_transaction.json");
             ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
             for (Transaction transaction : transactions)
                executorService.submit(new ExecuteTransaction(transaction,coins,traders, latch));

             executorService.shutdown();
             latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static JsonNode loadJsonNodeFromJSON(String filePath) {
        JsonNode jsonNode = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonNode = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        CryptoService cryptoService = new CryptoService(coins,traders,transactions);
        do {
            logger.info("\n=== Crypto Trading Application Menu ===c" +
                    "\n1. Retrieve Coin Details" +
                    "\n2. Display Top N Coins" +
                    "\n3. Show Trader's Portfolio" +
                    "\n4. Display Trader's Profit/Loss" +
                    "\n5. Show Top/Bottom Traders" +
                    "\n6. Exit" +
                    "\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:logger.info("\nEnter the name or id : ");
                    String input=scanner.next();
                    Optional<Coin> optionalCoin=cryptoService.getCoinDetails(input);
                    logger.info(optionalCoin.toString());
                    break;
                case 2:logger.info("\nEnter the number of Top coins: ");
                    int n=scanner.nextInt();
                    List<Coin> coinList=cryptoService.getTopCoinsByPrice(n);
                    logger.info(coinList.toString());
                    break;
                case 3:logger.info("\nEnter the trader id : ");
                    String traderId= scanner.next();
                    Map<String, Double> portfolio=cryptoService.getTraderPortfolio(traderId);
                    logger.info(convertMapToString(portfolio));
                    break;
                case 4:logger.info("\nEnter the trader id : ");
                    traderId= scanner.next();
                    logger.info("Profit/Loss : "+cryptoService.getTraderProfitOrLoss(traderId));
                    break;
                case 5:logger.info("\nEnter the number of Top coins: ");
                    n=scanner.nextInt();
                    logger.info(cryptoService.getTopAndBottomTraders(n).toString());
                      break;
                case 6:logger.info("Exiting Crypto Trading Application. Goodbye!");
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
    public static String convertMapToString(Map<String, Double> traderPortfolio) {

        String result = traderPortfolio.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
        return result;
    }
}
