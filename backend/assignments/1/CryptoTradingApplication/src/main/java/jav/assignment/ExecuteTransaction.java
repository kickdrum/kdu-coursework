package jav.assignment;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.concurrent.CountDownLatch;

public class ExecuteTransaction implements Runnable {
    private final JsonNode transactionNode;
    private final CountDownLatch latch;

    public ExecuteTransaction(JsonNode transactionNode, CountDownLatch latch) {
        this.transactionNode = transactionNode;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            String transactionType = transactionNode.get("type").asText();

            switch (transactionType) {
                case "BUY":
                    processBuyTransaction();
                    break;
                case "SELL":
                    processSellTransaction();
                    break;
                case "UPDATE_PRICE":
                    processUpdatePriceTransaction();
                    break;
                case "ADD_VOLUME":
                    processAddVolumeTransaction();
                    break;
                default:
                    System.out.println("Unsupported transaction type: " + transactionType);
            }

        } finally {

            latch.countDown();
        }
    }

    private void processBuyTransaction() {

        String coin = transactionNode.get("data").get("coin").asText();
        int quantity = transactionNode.get("data").get("quantity").asInt();
        String walletAddress = transactionNode.get("data").get("wallet_address").asText();
        Logging.logInfo"Processing BUY transaction: " + transactionNode);
    }

    private void processSellTransaction() {

        String coin = transactionNode.get("data").get("coin").asText();
        int quantity = transactionNode.get("data").get("quantity").asInt();
        String walletAddress = transactionNode.get("data").get("wallet_address").asText();

        Logging.logInfo("Processing SELL transaction: " + transactionNode);
    }

    private void processUpdatePriceTransaction() {
        String coin = transactionNode.get("data").get("coin").asText();
        double price = transactionNode.get("data").get("price").asDouble();

        Logging.logInfo("Processing UPDATE_PRICE transaction: " + transactionNode);
    }

    private void processAddVolumeTransaction() {
        String coin = transactionNode.get("data").get("coin").asText();
        int volume = transactionNode.get("data").get("volume").asInt();

        Logging.logInfo("Processing ADD_VOLUME transaction: " + transactionNode);
    }
}
