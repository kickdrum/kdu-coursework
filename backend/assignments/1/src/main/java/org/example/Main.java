package org.example;
import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.PortfolioManager.*;

public class Main {
    public static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);
    public static ArrayList<ArrayList<String>> coins = new ArrayList<>(); //for storing coins
    public static ArrayList<ArrayList<String>> traders = new ArrayList<>(); //for storing traders
    public static JsonNode jsonTransactions=null; //JsonNode object for storing transactions
    public static JsonNode[] transactions = null; //JsonNode object array for storing transactions in the form of array

    public static ArrayList<String[]> parseCSV(Path filePath) {
        ArrayList<String[]> csvData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath.toString()))) {
            reader.readNext();
            List<String[]> records = reader.readAll();
            csvData.addAll(records);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return csvData;
    }

    public static JsonNode parseJsonFile(String filePath) throws IOException {
        JsonNode jsonNode = null;
        Path file = Path.of(filePath);

        ObjectMapper objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(file.toFile());

        return jsonNode;
    }
    public static void main(String[] args) throws CsvValidationException {

        //parsing CSV  files
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/coins.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> row = new ArrayList<>();
                for (String value : nextLine) {
                    row.add(value);
                }
                coins.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parsing CSV  files of traders
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/traders.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> row = new ArrayList<>();
                for (String value : nextLine) {
                    row.add(value);
                }
                traders.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parsing JSON Files
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonTransactions = objectMapper.readTree(new File("src/main/resources/test_transaction.json"));

            transactions = new JsonNode[jsonTransactions.size()];
            for (int i = 0; i < jsonTransactions.size(); i++) {
                JsonNode node = jsonTransactions.get(i);
                transactions[i] = node;
            }

            // Process the JSON data (jsonNode)
        } catch (IOException e) {
            e.printStackTrace();
        }

        CountDownLatch latch = new CountDownLatch(jsonTransactions.size());
        executeTransactions(jsonTransactions,latch);

        slf4jLogger.info(" ");
        slf4jLogger.info("NOW WE WILL BE TESTING OUR HELPER FUNCTIONS:");
        // Print the details of a specific coin by code
        getCoinDetails("BTC");
        getCoinDetails("LUNA");
        slf4jLogger.info(" ");


        // Display top 3 coins based on price
        displayTopCoins(3);
        slf4jLogger.info(" ");

        // Show portfolio of a given trader
        showTraderPortfolio("0x5a1fcde6a86ea0dd483f33d81f35000f");
        showTraderPortfolio("0x9c79042a5f769f6c2395b0d51be7677e");
        showTraderPortfolio("0xaf903c532c73b66c934f6e2356344bb0");
        slf4jLogger.info(" ");

        // Calculate profit/loss for a given trader
        calculateTraderProfitLoss("0x5a1fcde6a86ea0dd483f33d81f35000f");
        calculateTraderProfitLoss("0x9c79042a5f769f6c2395b0d51be7677e");
        calculateTraderProfitLoss("0xaf903c532c73b66c934f6e2356344bb0");
        slf4jLogger.info(" ");


        // Display top 5 and bottom 5 traders based on profit/loss
        displayTopBottomTraders(5);

    }

    public static void executeTransactions(JsonNode jsonTransactions,CountDownLatch latch) {
            ExecutorService executorService = Executors.newFixedThreadPool(jsonTransactions.size());

            for (JsonNode jsonNode : jsonTransactions) {
               String type = jsonNode.get("type").asText();
               JsonNode dataNode = jsonNode.get("data");

                Runnable transactionRunnable = new ExecuteTransaction(type, dataNode, latch, coins, traders);
              executorService.submit(transactionRunnable);
            }

            // Wait for all transactions to finish
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                // Shutdown the executor after all transactions are done
                executorService.shutdown();

        }
}