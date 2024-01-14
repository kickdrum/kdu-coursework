package backend.assignment;

import backend.assignment.logging.LogBack;
import backend.assignment.transaction.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Random;

public class ExecuteTransaction implements Runnable{
    JsonNode jsonNode;
    TransactionData transactionData;
    Market market;
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
    ExecuteTransaction(JsonNode inputTransaction,Market market) {
        String type = inputTransaction.get("type").asText();
        transactionData = new TransactionData();
        JsonNode dataNode = inputTransaction.get("data");

        Transaction transaction = null;
        String coinName = dataNode.get("coin").asText();

        switch (type){
            case "BUY":
                LogBack.infoLogger("Executing Buy Transaction..");
                String buyWalletNumber = dataNode.get("wallet_address").asText();
                long buyVolume = dataNode.get("quantity").asLong();
                transaction = new BuyTransaction(buyVolume,buyWalletNumber,market);
                break;
            case "SELL":
                LogBack.infoLogger("Executing Sell Transaction..");
                String sellWalletNumber = dataNode.get("wallet_address").asText();
                long sellVolume = dataNode.get("quantity").asLong();
                transaction = new SellTransaction(sellVolume,sellWalletNumber,market);
                break;
            case "UPDATE_PRICE":
                LogBack.infoLogger("Executing Update_Price Transaction..");
                double price = dataNode.get("price").asDouble();
                transaction = new UpdatePriceTransaction(price,market);
                break;
            case "ADD_VOLUME":
                LogBack.infoLogger("Executing ADD_VOLUME Transaction..");
                Long volume = dataNode.get("volume").asLong();
                transaction = new AddVolumeTransaction(volume,market);
                break;
            default: LogBack.debugLogger("Invalid Transaction Type");
                    break;
        }
        transactionData.setHash(getBlockHash());
        transactionData.setType(type);


        assert transaction != null;
        transaction.setType(type);
        transaction.setCoinName(coinName);

        transactionData.setData(transaction);
    }
    @Override
    public void run() {
        if(this.transactionData.performTransaction()){
            LogBack.infoLogger("Transaction has been executed Successfully!");
        } else {
            LogBack.errorLogger("Transaction Failed!!");
        }
    }
}
