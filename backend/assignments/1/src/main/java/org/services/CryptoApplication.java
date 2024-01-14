package org.services;
import com.fasterxml.jackson.core.JsonParser;
import com.opencsv.exceptions.CsvValidationException;
import org.models.Coin;
import org.models.Trader;
import org.models.Transaction;
import com.opencsv.*;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.TransactionType;
public class CryptoApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Coin> coins = loadCoinsFromCSV("src/main/resources/coins.csv");
        System.out.println("coins.csv File loaded successfully");

        List<Trader> traders=loadTraderFromCSV("src/main/resources/traders.csv");
        System.out.println("traders.csv File loaded successfully");

        List<Transaction> transactions=loadTransactionsFromJSON("src/main/resources/small_transaction.json");
        System.out.println("large_transaction.csv File loaded successfully");

        JsonNode jsonNode=loadJsonNodeFromJSON("src/main/resources/small_transaction.json");
        System.out.println("JsonNode loaded successfully");

        CryptoService cryptoService=new CryptoService(coins,traders,transactions);

        cryptoService.processTransactionsInThreadPool();

    }

    /**
     *
     * @param filePath
     * @return
     */
    public static List<Coin> loadCoinsFromCSV(String filePath) {
        List<Coin> coins = new ArrayList<>();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                try {
                    int rank= Integer.parseInt(line[1]);
                    String name = line[2];
                    String symbol = line[3];
                    double price = isNumeric(line[4]) ? Double.parseDouble(line[4]) : 0.0;
                    long volume = isNumeric(line[5]) ? Long.parseLong(line[5]) : 0;
                    Coin coin = new Coin(rank,name, symbol, price, volume);
                    //System.out.println(line[0]+" "+line[1]);
                    coins.add(coin);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing csv file: " + e.getMessage());
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return coins;
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static List<Trader> loadTraderFromCSV(String filePath) {
        List<Trader> traders = new ArrayList<>();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                try {
                    String id= line[1];
                    String firstName = line[2];
                    String lastName = "";//line[2];
                    String phone=line[3];
                    String walletAddress=line[4];

                    Trader trader = new Trader(id,firstName, lastName,phone,walletAddress);
                    traders.add(trader);

                } catch (NumberFormatException e) {
                    System.err.println("Error parsing csv file: " + e.getMessage());
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return traders;
    }

    /**
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static List<Transaction> loadTransactionsFromJSON(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> transactionsList = objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> transactionMap : transactionsList) {
                String type = (String) transactionMap.get("type");
                JsonNode dataNode = objectMapper.convertValue(transactionMap.get("data"), JsonNode.class);

                TransactionType transactionType = TransactionType.valueOf(type);
                Transaction transaction = createTransactionFromJsonNode(transactionType, dataNode);

                transactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    /**
     *
     * @param type
     * @param dataNode
     * @return
     */
    public static Transaction createTransactionFromJsonNode(TransactionType type, JsonNode dataNode) {
        String coin = dataNode.get("coin").asText();
        double quantity = dataNode.has("quantity") ? dataNode.get("quantity").asDouble() : 0.0;
        String walletAddress = dataNode.has("wallet_address") ? dataNode.get("wallet_address").asText() : "";

        Transaction transaction = new Transaction(coin, type, quantity, walletAddress);

        if (type == TransactionType.UPDATE_PRICE && dataNode.has("price"))
            transaction.setAmount(dataNode.get("price").asDouble());

        return transaction;
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static JsonNode loadJsonNodeFromJSON(String filePath) {
        JsonNode jsonNode = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonNode = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
        return jsonNode;
    }
}