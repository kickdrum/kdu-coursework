
package org.handson.entitites.transactiondata;

import org.handson.Constants;
import org.handson.entitites.concrete.Trader;
import org.handson.entitites.repositories.CoinRepository;
import org.handson.entitites.repositories.TraderRepository;
import org.handson.logger.MyLogger;

public class BuyTransactionData implements TransactionData{
    private String type;
    private String coinName;
    private long quantity;
    private String traderWalletNumber;
    public String getTraderWalletNumber() {
        return traderWalletNumber;
    }
    public void setTraderWalletNumber(String traderWalletNumber) {
        this.traderWalletNumber = traderWalletNumber;
    }
    public BuyTransactionData( long quantity, String traderWalletNumber)
    {
        this.quantity = quantity;
        this.traderWalletNumber = traderWalletNumber;
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
        MyLogger.customLogger("BUYINGG ",Constants.INFO_LOGGER);
        Trader trader = TraderRepository.getTrader(traderWalletNumber);
      
        if(CoinRepository.getInstance().updateVolume(coinName, quantity,"BUY"))
        {

            trader.addCoin(coinName,CoinRepository.getInstance().getCoinPrice(coinName),quantity);
            synchronized (trader) {
                trader.notifyAll();
            }
            MyLogger.customLogger("Coin bought successfully "+traderWalletNumber+" coin name: "+coinName, Constants.INFO_LOGGER);
            return true;
        }
        else
        {
            MyLogger.customLogger("Error in buying the coin. ", Constants.ERROR_LOGGER);
            return false;
        }

        
    }

}
