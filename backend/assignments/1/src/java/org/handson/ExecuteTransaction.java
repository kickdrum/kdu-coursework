package org.handson;

import java.util.Random;

import org.handson.entitites.concrete.Transaction;
import org.handson.entitites.transactiondata.BuyTransactionData;
import org.handson.entitites.transactiondata.SellTransactionData;
import org.handson.entitites.transactiondata.TransactionData;
import org.handson.entitites.transactiondata.UpdatePriceTransactionData;
import org.handson.entitites.transactiondata.VolumeTransactionData;

import com.fasterxml.jackson.databind.JsonNode;
import org.handson.logger.MyLogger;

public class ExecuteTransaction implements Runnable {
    JsonNode jsonNode;
    Transaction transactionObj;

    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
        /**
         * Introducing delay mimicking complex
         * calculation being performed.
         */
        for (double i = 0; i < 199999999; i++) {
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }
    ExecuteTransaction(){};
    ExecuteTransaction(JsonNode transaction) {
        String type = transaction.get("type").asText();
        transactionObj = new Transaction();
        JsonNode dataNode = transaction.get("data");
        TransactionData transactionData;
        String coinName = dataNode.get("coin").asText();

        switch (type) {
            case "BUY":
                MyLogger.customLogger("Executing transaction Buy", Constants.INFO_LOGGER);
                String walletNumber = dataNode.get("wallet_address").asText();
                String volume = dataNode.get("quantity").asText();
                transactionData = new BuyTransactionData(Long.parseLong(volume), walletNumber);
                break;

            case "SELL":
                MyLogger.customLogger("Executing transaction Sell", Constants.INFO_LOGGER);
                String sellWalletNumber = dataNode.get("wallet_address").asText();
                String sellVolume = dataNode.get("quantity").asText();
                transactionData = new SellTransactionData(Long.parseLong(sellVolume), sellWalletNumber);
                break;

            case "UPDATE_PRICE":
                MyLogger.customLogger("Executing transaction Update price", Constants.INFO_LOGGER);
                String price = dataNode.get("price").asText();
                transactionData = new UpdatePriceTransactionData(Double.parseDouble(price), coinName);
                break;

            default:
                MyLogger.customLogger("Executing transaction Update volume", Constants.INFO_LOGGER);
                Long updateVolume = dataNode.get("volume").asLong();
                transactionData = new VolumeTransactionData(updateVolume);
                break;
        }

        transactionObj.setHash(getBlockHash());
        transactionObj.setType(type);
        transactionData.setCoinName(coinName);
        transactionData.setType(type);

        transactionObj.setData(transactionData);


    }

    @Override
    public void run() {

       if(this.transactionObj.performTransaction())
       {

           MyLogger.customLogger("Transaction executed successfully",Constants.DEBUG_LOGGER);
       }
       else
       {
           MyLogger.customLogger("Error with transaction execution",Constants.ERROR_LOGGER);
       }
    }
}
