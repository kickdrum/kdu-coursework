package jav.assignment.Functions;
import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;
import jav.assignment.traders.Trader;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

class SortByPrice implements Comparator<Coin> {
    public int compare(Coin a, Coin b) {
        return Double.compare(a.getPrice(), b.getPrice());
    }
}

class SortByProfit implements Comparator<Trader> {
    public int compare(Trader a, Trader b) {return Double.compare(a.getProfit(), b.getProfit()); }
}

public class MenuFunctions {
    public static void getDetailsByNameOrCodeOfCoin() {
        Scanner sc = new Scanner(System.in);
        Logging.logInfo("1 -> Get Coin details by Name\n2 -> Get Coin details by Symbol");
        int input = sc.nextInt();
        if(input == 1) {
            sc.nextLine();
            Logging.logInfo("Enter a name of coin");
            String coinName = sc.nextLine();
            Logging.logInfo(GlobalData.coinNameAndCoinObject.get(coinName).toString());
        }
        else if(input == 2) {
            sc.nextLine();

            Logging.logInfo(GlobalData.coinSymbolAndCoinObject.size());
            Logging.logInfo("Enter a symbol of coin");
            String coinSymbol = sc.nextLine();
            Logging.logInfo(GlobalData.coinSymbolAndCoinObject.get(coinSymbol.toUpperCase()).toString());
        }
        else {
            Logging.logInfo("Enter a valid choice");
        }
    }

    public static void get50CoinsOnPrice() {
        HashMap<String, Coin> top50Coins = GlobalData.coinSymbolAndCoinObject.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(new SortByPrice())))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        int counter = 0;
        Logging.logInfo("Top 50 coins based on the price: ");
        for(String symbol : top50Coins.keySet()) {
            counter++;
            Logging.logInfo("Coin " + counter + ": " + top50Coins.get(symbol).toString());

            if(counter == 50)
                break;
        }
    }

    public static void getPortfolioByName() {
        Scanner sc = new Scanner(System.in);
        Logging.logInfo("Enter name");
        String name = sc.nextLine();
        Logging.logInfo(GlobalData.allTraderList.size());
        for(Trader trader : GlobalData.allTraderList) {

            if(trader.getFirstName().equals(name)) {
                Logging.logInfo(trader.toString());
            }
        }
    }

    public static void ProfitAndLossOfEachTrader(String name) {
        int total = GlobalData.allTraderList.size();
        for(int i = 0; i < total; i++) {
            if(name.equals(GlobalData.allTraderList.get(i).getFirstName())) {
                Logging.logInfo("Transaction Profit/Loss is " + GlobalData.allTraderList.get(i).getProfit());
                return;
            }
            else Logging.logInfo("Trader not Found..!");
        }
    }

    public static void TopNBottomNTraders(int n) {
        if(GlobalData.allTraderList.size() < n) {
            Logging.logInfo("There are less traders than expected");
        }
        else {
            List<Trader> topNTraders = GlobalData.allTraderList.stream().sorted(Collections.reverseOrder(new SortByProfit())).limit(n).collect(Collectors.toList());
            Logging.logInfo("Top " + n + "Top/Bottom Traders based on Profit");
            List<Trader> BottomNTraders = GlobalData.allTraderList.stream().sorted(new SortByProfit()).limit(n).collect(Collectors.toList());

            for (Trader trader : topNTraders)
                Logging.logInfo(trader.toString());
            Logging.logInfo();
            for (Trader trader : BottomNTraders)
                Logging.logInfo(trader.toString());
        }
    }
}