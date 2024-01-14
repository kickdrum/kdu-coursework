package jav.assignment;

import jav.assignment.Coins.Coin;
import jav.assignment.Entities.*;
import jav.assignment.globalObjects.GlobalData;
import jav.assignment.readFiles.ReadCoins;
import jav.assignment.readFiles.ReadJSON;
import jav.assignment.Transactions.*;

import jav.assignment.Functions.MenuFunctions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            GlobalData.readData();
            MenuDriven md = new MenuDriven();
            md.start();

            JSONArray transaction = null;
            transaction = ReadJSON.JSONFileReader("src/main/resources/small_transaction.json", transaction);

            CountDownLatch latch = new CountDownLatch(transaction.size());
            executeTransactions(transaction, latch);
            // Wait for all transactions to complete
            latch.await();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeTransactions(JSONArray jsonTransactions, CountDownLatch latch) {
        try {
            for (Object obj : jsonTransactions) {
                JSONObject temp = (JSONObject) obj;

                if (ReadJSON.parseTypeForJSONObject(temp).equals("BUY")) {
                    try {
                        Buy buy = new Buy((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread buyCoinTransaction = new BuyTransaction(buy, latch);
                        buyCoinTransaction.start();
                    } catch (Exception e) {
                        System.out.println("Hello");
                        e.printStackTrace();
                    }
                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("SELL")) {
                    try {
                        Sell sell = new Sell((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread sellCoinTransaction = new SellTransaction(sell, latch);
                        sellCoinTransaction.start();
                    } catch (Exception e) {
                        System.out.println("sell");
                        System.out.println(e.getMessage());
                    }
                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("ADD_VOLUME")) {
                    try {
                        IncreaseVolume IncreaseVolume = new IncreaseVolume((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread addVolumeTransaction = new IncreaseVolumeTransaction(IncreaseVolume, latch);
                        addVolumeTransaction.start();
                    } catch (Exception e) {
                        System.out.println("add volume");
                        System.out.println(e.getMessage());
                    }
                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("UPDATE_PRICE")) {
                    try {
                        UpdatePrice updatePrice = new UpdatePrice((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread updatePriceTransaction = new UpdatePriceTransaction(updatePrice, latch);
                        updatePriceTransaction.start();
                    } catch (Exception e) {
                        System.out.println("update price");
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//import com.fasterxml.jackson.databind.JsonNode;
//
//import java.assignment.Coins.Coin;
//import java.assignment.Entities.*;
//import java.assignment.globalObjects.GlobalData;
//import java.assignment.readFiles.ReadCoins;
//import java.assignment.readFiles.ReadJSON;
//
//import org.json.JSONObject;
//import org.json.simple.JSONArray;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.concurrent.CountDownLatch;
//
//import static java.assignment.globalObjects.GlobalData.allTraderList;
//import static java.assignment.globalObjects.GlobalData.tradersData;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        try {
//            // Initialize HashMaps to store coin data
//            HashMap<String, Coin> coinNameAndCoinObject = new HashMap<>();
//            HashMap<String, Coin> coinSymbolAndCoinObject = new HashMap<>();
//
//            // Specify the path to the coins.csv file
//            String coinsCsvFilePath = "src/main/resources/coins.csv";
//
//            // Read data from the CSV file using ReadCoins class
//            ReadCoins.readDataFromCoins(coinsCsvFilePath, coinNameAndCoinObject, coinSymbolAndCoinObject);
//
//            // Load traders data into memory (Assuming there is a method to load traders)
//            GlobalObjects.readData(tradersData, allTraderList);
//
//            MenuDriven md = new MenuDriven();
//            md.start();
//
//            // Load JSON file containing transaction data into memory
//            JsonNode transactionData = ReadJSON.JSONFileReader("src/main/resources/small_transaction.json");
//
//            // Create a CountDownLatch with the number of transactions
//            CountDownLatch latch = new CountDownLatch(transactionData.size());
//
//            // Execute transactions
//            executeTransactions(transactionData, latch);
//
//            // Wait for all transactions to complete
//            latch.await();
//
//            // Perform any post-execution tasks if needed
//            System.out.println("All transactions completed.");
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
//        try {
//            for (JsonNode node : jsonTransactions) {
//                org.json.simple.JSONObject temp = (org.json.simple.JSONObject) ReadJSON.convertJsonNodeToJsonObject(node);
//
//                if (ReadJSON.parseTypeForJSONObject(temp).equals("BUY")) {
//                    // Create a Buy object and pass it to the ExecuteTransaction class
//                    Buy buy = new Buy((JSONObject) ReadJSON.parseDataForJSONObject(temp));
//                    Thread buyCoinTransaction = new Thread(new ExecuteTransaction(buy, latch));
//                    buyCoinTransaction.start();
//                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("SELL")) {
//                    // Create a Sell object and pass it to the ExecuteTransaction class
//                    Sell sell = new Sell((JSONObject) ReadJSON.parseDataForJSONObject(temp));
//                    Thread sellCoinTransaction = new Thread(new ExecuteTransaction(sell, latch));
//                    sellCoinTransaction.start();
//                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("ADD_VOLUME")) {
//                    // Create an IncreaseVolume object and pass it to the ExecuteTransaction class
//                    IncreaseVolume addVolume = new IncreaseVolume((JSONObject) ReadJSON.parseDataForJSONObject(temp));
//                    Thread addVolumeTransaction = new Thread(new ExecuteTransaction(addVolume, latch));
//                    addVolumeTransaction.start();
//                } else if (ReadJSON.parseTypeForJSONObject(temp).equals("UPDATE_PRICE")) {
//                    // Create an UpdatePrice object and pass it to the ExecuteTransaction class
//                    UpdatePrice updatePrice = new UpdatePrice((JSONObject) ReadJSON.parseDataForJSONObject(temp));
//                    Thread updatePriceTransaction = new Thread(new ExecuteTransaction(updatePrice, latch));
//                    updatePriceTransaction.start();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
