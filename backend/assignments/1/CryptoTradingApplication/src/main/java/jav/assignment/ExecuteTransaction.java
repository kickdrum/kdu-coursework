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
            // Count down the latch to signal completion
            latch.countDown();
        }
    }

    private void processBuyTransaction() {
        // Extract necessary information from the transactionNode
        String coin = transactionNode.get("data").get("coin").asText();
        int quantity = transactionNode.get("data").get("quantity").asInt();
        String walletAddress = transactionNode.get("data").get("wallet_address").asText();

        // Implement your BUY transaction logic here
        // For example, update data in GlobalData or perform other operations
        System.out.println("Processing BUY transaction: " + transactionNode);
    }

    private void processSellTransaction() {
        // Extract necessary information from the transactionNode
        String coin = transactionNode.get("data").get("coin").asText();
        int quantity = transactionNode.get("data").get("quantity").asInt();
        String walletAddress = transactionNode.get("data").get("wallet_address").asText();

        // Implement your SELL transaction logic here
        // For example, update data in GlobalData or perform other operations
        System.out.println("Processing SELL transaction: " + transactionNode);
    }

    private void processUpdatePriceTransaction() {
        // Extract necessary information from the transactionNode
        String coin = transactionNode.get("data").get("coin").asText();
        double price = transactionNode.get("data").get("price").asDouble();

        // Implement your UPDATE_PRICE transaction logic here
        // For example, update data in GlobalData or perform other operations
        System.out.println("Processing UPDATE_PRICE transaction: " + transactionNode);
    }

    private void processAddVolumeTransaction() {
        // Extract necessary information from the transactionNode
        String coin = transactionNode.get("data").get("coin").asText();
        int volume = transactionNode.get("data").get("volume").asInt();

        // Implement your ADD_VOLUME transaction logic here
        // For example, update data in GlobalData or perform other operations
        System.out.println("Processing ADD_VOLUME transaction: " + transactionNode);
    }
}
