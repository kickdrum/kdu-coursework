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
