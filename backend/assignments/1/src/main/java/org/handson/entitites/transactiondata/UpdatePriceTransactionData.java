package org.handson.entitites.transactiondata;

import org.handson.Constants;
import org.handson.entitites.repositories.CoinRepository;
import org.handson.logger.MyLogger;

public class UpdatePriceTransactionData implements TransactionData {
      private String type;
    private String coinName;
    private Double price;
    public UpdatePriceTransactionData(Double price, String coinName)
    {
        this.price = price;
        this.coinName = coinName;
    }
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getCoinName() {
        return this.coinName;
    }

    public void setCoinName(String coinName)
    {
         this.coinName = coinName;
    }
    
    public  boolean performTransaction()
    {   
    if(CoinRepository.getInstance().updateCoinPrice(coinName, price))
    {
        MyLogger.customLogger("Coin price updated successfully", Constants.INFO_LOGGER);
        return true;
    }
    MyLogger.customLogger(coinName+" not found", Constants.ERROR_LOGGER);
    return false;
    }
}
