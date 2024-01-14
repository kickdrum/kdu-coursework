package org.example.globalObjects;

import org.example.coins.Coin;
import org.example.traders.Trader;
import org.example.readFiles.ReadTraders;
import org.example.readFiles.ReadCoins;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalData {

    public static HashMap<String, Trader> tradersData = new HashMap<>();
    public static HashMap<String, Coin> coinNameAndCoinObject = new HashMap<>();
    public static HashMap<String, Coin> coinSymbolAndCoinObject = new HashMap<>();
    public static List<Trader> allTraderList = new ArrayList<>();
    public static JSONArray transaction;


    public static void readData() throws IOException {
        ReadCoins.readDataFromCoins(coinNameAndCoinObject, coinSymbolAndCoinObject);
        ReadTraders.readDataFromTraders(tradersData, allTraderList);
    }
}
