package org.example.main;
import org.example.Transactions.AddVolumeTransaction;
import org.example.Transactions.BuyCoinTransaction;
import org.example.Transactions.SellCoinTransaction;
import org.example.Transactions.UpdatePriceTransaction;
import org.example.entities.AddVolume;
import org.example.entities.Buy;
import org.example.entities.Sell;
import org.example.entities.UpdatePrice;
import org.example.globalObjects.GlobalData;
import org.example.readFiles.ReadJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        try {
//        JSONArray transaction = null;
            GlobalData.readData();
            MenuDriven md = new MenuDriven();
            md.start();
            JSONArray transaction = null;
            transaction = ReadJSON.JSONFileReader("src/main/resources/test_transaction.json", transaction);
            //            System.out.println("size is " + transaction.size());
            for (Object obj : transaction) {

                JSONObject temp = (JSONObject) obj;
                if (ReadJSON.parseTypeForJSONObject(temp).equals("BUY")) {
                    try {
                        Buy buy = new Buy((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread buyCoinTransaction = new BuyCoinTransaction(buy);
                        buyCoinTransaction.start();
                    }
                    catch (Exception e) {
                        System.out.println("Hello");
                        e.printStackTrace();
                    }
                }
                else if(ReadJSON.parseTypeForJSONObject(temp).equals("SELL")) {
                    try {
                        Sell sell = new Sell((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread sellCoinTransaction = new SellCoinTransaction(sell);
                        sellCoinTransaction.start();
                    } catch (Exception e) {
                        System.out.println("sell");
                        System.out.println(e.getMessage());
                    }
                } else if(ReadJSON.parseTypeForJSONObject(temp).equals("ADD_VOLUME")) {
                    try {
                        AddVolume addVolume = new AddVolume((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread addVolumeTransaction = new AddVolumeTransaction(addVolume);
                        addVolumeTransaction.start();
                    } catch (Exception e) {
                        System.out.println("add volume");
                        System.out.println(e.getMessage());
                    }
                } else if(ReadJSON.parseTypeForJSONObject(temp).equals("UPDATE_PRICE")) {
                    try {
                        UpdatePrice updatePrice = new UpdatePrice((JSONObject) ReadJSON.parseDataForJSONObject(temp));
                        Thread updatePriceTransaction = new UpdatePriceTransaction(updatePrice);
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
