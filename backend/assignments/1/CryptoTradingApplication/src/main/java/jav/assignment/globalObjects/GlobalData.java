package jav.assignment.globalObjects;

import jav.assignment.Coins.Coin;
import jav.assignment.traders.Trader;
import jav.assignment.readFiles.ReadTraders;
import jav.assignment.readFiles.ReadCoins;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlobalData {

    public static HashMap<String, Trader> tradersData = new HashMap<>();
    public static HashMap<String, Coin> coinNameAndCoinObject = new HashMap<>();
    public static HashMap<String, Coin> coinSymbolAndCoinObject = new HashMap<>();
    public static List<Trader> allTraderList = new ArrayList<>();
    public static JSONArray transaction;


    public static void readData() throws IOException {
        String coinsCsvFilePath = null;
        ReadCoins.readDataFromCoins(coinsCsvFilePath, coinNameAndCoinObject, coinSymbolAndCoinObject);
        ReadTraders.readDataFromTraders(tradersData, allTraderList);
    }
}