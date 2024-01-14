package org.handson.entitites.repositories;

import org.handson.Constants;
import org.handson.entitites.concrete.Trader;
import org.handson.logger.MyLogger;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class AscendingComparator implements Comparator<Trader> {
    @Override
    public int compare(Trader a, Trader b) {
        return Double.compare(a.getNetProfit(), b.getNetProfit());
    }
}

class DescendingComparator2 implements Comparator<Trader> {
    @Override
    public int compare(Trader a, Trader b) {
        return Double.compare(b.getNetProfit(), a.getNetProfit());
    }
}

public class TraderRepository {
    private static HashMap<String, Trader> traderMap = new HashMap<>();


    private TraderRepository() {
    }
    /**
     * Retrieves the Trader object associated with the given wallet address.
     *
     * @param walletAddress the wallet address of the trader
     * @return the Trader object associated with the wallet address, or null if not
     *         found
     */
    public static synchronized Trader getTrader(String walletAddress) {
        Trader trader = traderMap.get(walletAddress);
        if (trader == null) {
            MyLogger.customLogger("Trader not found" + walletAddress, Constants.ERROR_LOGGER);
        } else {
            MyLogger.customLogger("Trader found", Constants.INFO_LOGGER);
        }
        return trader;
    }

    /**
     * Displays the trader information for the given wallet address.
     *
     * @param walletAddress the wallet address of the trader
     */
    public static void displayTrader(String walletAddress) {
        Trader trader = traderMap.get(walletAddress);
        if (trader == null) {
            MyLogger.customLogger("Trader not found" + walletAddress, Constants.ERROR_LOGGER);
        } else {
            MyLogger.customLogger(trader.toString(), Constants.DEBUG_LOGGER);
            MyLogger.customLogger("Trader found", Constants.INFO_LOGGER);
        }
    }

    /**
     * Shows the top n traders based on a descending order of their values.
     *
     * @param n the number of top traders to be shown
     */
    public static void showTopNTraders(int n) {
        List<Trader> topNTraders = traderMap.values()
                .stream()
                .sorted(new DescendingComparator2())
                .limit(n)
                .toList();

        MyLogger.customLogger("Top " + n + " Traders:", Constants.INFO_LOGGER);
        topNTraders.forEach(trader -> MyLogger.customLogger(trader.toString(), Constants.INFO_LOGGER));
    }

    /**
     * Show the bottom n traders.
     *
     * @param n the number of traders to show
     * @return void
     */
    public static void showBottomMTraders(int n) {
        List<Trader> bottomMTraders = traderMap.values()
                .stream()
                .sorted(new AscendingComparator())
                .limit(n)
                .toList();

        MyLogger.customLogger("Bottom " + n + " Traders:", Constants.INFO_LOGGER);
        bottomMTraders.forEach(trader -> MyLogger.customLogger(trader.toString(), Constants.INFO_LOGGER));
    }


    /**
     * Loads data from a CSV file into the traderMap.
     *
     * @return None
     */
    public static void load() {
        String fileName = Constants.FILE_TRADER_CSV;

        try (CSVReader reader = new CSVReader(new FileReader(fileName));) {

            reader.readNext();
            List<String[]> csvData = reader.readAll();

            for (String[] row : csvData) {

                String firstName = row[1];
                String lastName = row[2];
                String phoneNumber = row[3];
                String walletAddress = row[4];

                Trader trader = new Trader();
                trader.setFirstName(firstName);
                trader.setLastName(lastName);
                trader.setPhoneNumber(phoneNumber);
                trader.setWalletAddress(walletAddress);
                trader.setNetProfit(0.0);

                traderMap.put(walletAddress, trader);
            }

            MyLogger.customLogger("Traders loaded successfully.", Constants.INFO_LOGGER);
        } catch (Exception e) {
            MyLogger.customLogger("Error loading traders from CSV: " + e.getMessage(), Constants.ERROR_LOGGER);
        }
    }

}
