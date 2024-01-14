package org.handson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.opencsv.CSVReader;
import org.handson.entitites.repositories.CoinRepository;
import org.handson.entitites.repositories.TraderRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * name: means symbol, for a coin name is same but for transactions name is
 * symbol
 */
public class Main {

    public Main() {
        TraderRepository.load();
        CoinRepository.getInstance().load();
    }

    public static ArrayList<String[]> parseCSV(Path filePath) {
        ArrayList<String[]> csvData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath.toString()))) {
            reader.readNext();
            List<String[]> records = reader.readAll();
            csvData.addAll(records);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
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

    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
        int transactionCount = jsonTransactions.size();
        ExecutorService executor = Executors.newFixedThreadPool(transactionCount);
        for (JsonNode transaction : jsonTransactions) {
            executor.execute(new ExecuteTransaction(transaction));
            latch.countDown();
        }
        executor.shutdown();

    }

    public static void main(String[] args) {
        TraderRepository.load();
        CoinRepository.getInstance().load();
        String jsonFilePath = Constants.FILE_JSON_PATH;
        try {
            File jsonFile = new File(jsonFilePath);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonTransactions = mapper.readTree(jsonFile);
            int transactionCount = jsonTransactions.size();
            CountDownLatch latch = new CountDownLatch(transactionCount);
            executeTransactions(jsonTransactions, latch);
            latch.await();
            TraderRepository.showTopNTraders(5);
            TraderRepository.showBottomMTraders(5);
            CoinRepository.getInstance().displayCoinDetails("LUNA");
            CoinRepository.getInstance().showTopNCoins(5);
            TraderRepository.displayTrader("0x344427a90da861f79cc80bac2ff8638f");
        } catch (Exception e) {
            Thread.currentThread().interrupt();

        }

    }
}