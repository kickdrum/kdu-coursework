package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teams {
    public static Map<String, ArrayList> teams = new HashMap<>();

    public static void updateTeam(Player player) {
        if (!teams.containsKey(player.getTeam())) {
            teams.put(player.getTeam(), new ArrayList<String>());
        }

        ArrayList team = teams.get(player.getTeam());


        if (!team.contains(player.getName())) {
            team.add(player.getName());
        }

//        int currentQuantity = traderPortfolio.get(coin);
//        int updatedQuantity = currentQuantity + quantity;
//
//        if (updatedQuantity >= 0) {
//            traderPortfolio.put(coin, updatedQuantity);
//            if (quantity > 0) {
//                double transactionValue = quantity * price;
//                double totalInvestment = traderPortfolio.getOrDefault("totalInvestment", 0);
//                traderPortfolio.put("totalInvestment", (int) (totalInvestment + transactionValue));
//            }
//        } else {
//            slf4jLogger.info("Error: Negative quantity in the portfolio");
//        }
    }
}
