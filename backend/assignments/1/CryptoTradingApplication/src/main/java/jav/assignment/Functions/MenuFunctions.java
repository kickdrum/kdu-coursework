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
        System.out.println("1 -> Get Coin details by Name\n2 -> Get Coin details by Symbol");
        int input = sc.nextInt();
        if(input == 1) {
            sc.nextLine();
            System.out.println("Enter a name of coin");
            String coinName = sc.nextLine();
            System.out.println(GlobalData.coinNameAndCoinObject.get(coinName).toString());
        }
        else if(input == 2) {
            sc.nextLine();

            System.out.println(GlobalData.coinSymbolAndCoinObject.size());
            System.out.println("Enter a symbol of coin");
            String coinSymbol = sc.nextLine();

//            System.out.println(coinSymbol);
//            System.out.println(GlobalData);
            System.out.println(GlobalData.coinSymbolAndCoinObject.get(coinSymbol.toUpperCase()).toString());
        }
        else {
            System.out.println("Enter a valid choice");
        }
    }

    public static void get50CoinsOnPrice() {
        HashMap<String, Coin> top50Coins = GlobalData.coinSymbolAndCoinObject.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(new SortByPrice())))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        int counter = 0;
        System.out.println("Top 50 coins based on the price: ");
        for(String symbol : top50Coins.keySet()) {
            counter++;
            System.out.println("Coin " + counter + ": " + top50Coins.get(symbol).toString());

            if(counter == 50)
                break;
        }
    }

    public static void getPortfolioByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println(GlobalData.allTraderList.size());
        for(Trader trader : GlobalData.allTraderList) {

            if(trader.getFirstName().equals(name)) {
                System.out.println(trader.toString());
            }
        }
    }

    public static void ProfitAndLossOfEachTrader(String name) {
        int total = GlobalData.allTraderList.size();
        for(int i = 0; i < total; i++) {
            if(name.equals(GlobalData.allTraderList.get(i).getFirstName())) {
                System.out.println("Transaction Profit/Loss is " + GlobalData.allTraderList.get(i).getProfit());
                return;
            }
            else System.out.println("Trader not Found..!");
        }
    }
    //1.01,89002738
    public static void TopNBottomNTraders(int n) {
        if(GlobalData.allTraderList.size() < n) {
            System.out.println("There are less traders than expected");
        }
        else {
            List<Trader> topNTraders = GlobalData.allTraderList.stream().sorted(Collections.reverseOrder(new SortByProfit())).limit(n).collect(Collectors.toList());
            System.out.println("Top " + n + "Top/Bottom Traders based on Profit");
            List<Trader> BottomNTraders = GlobalData.allTraderList.stream().sorted(new SortByProfit()).limit(n).collect(Collectors.toList());

            for (Trader trader : topNTraders)
                System.out.println(trader.toString());
            System.out.println();
            for (Trader trader : BottomNTraders)
                System.out.println(trader.toString());
        }
    }
}