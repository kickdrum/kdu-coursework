
package org.handson.entitites.transactiondata;

import org.handson.Constants;
import org.handson.entitites.concrete.Trader;
import org.handson.entitites.repositories.CoinRepository;
import org.handson.entitites.repositories.TraderRepository;
import org.handson.logger.MyLogger;

public class SellTransactionData implements TransactionData{
    private String type;
    private String coinName;
    private long quantity;
    private String traderWalletNumber;
   public SellTransactionData( long quantity, String traderWalletNumber)
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
    
    public synchronized boolean performTransaction() {
        MyLogger.customLogger("SELLINGG",Constants.INFO_LOGGER);
        Trader trader = TraderRepository.getTrader(traderWalletNumber);
        while(!trader.isBought(coinName))
        {
            MyLogger.customLogger("Coin not bought by "+traderWalletNumber+" coin name "+coinName+" price "+quantity, Constants.DEBUG_LOGGER);
            MyLogger.customLogger("Waiting for the trader to buy the coin!",Constants.INFO_LOGGER);
            try {
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                MyLogger.customLogger("Interrupted while waiting for the trader to buy the coin.", Constants.ERROR_LOGGER);
                return false;
            }

        }
    MyLogger.customLogger("Trying to sell the coin",Constants.INFO_LOGGER);
        if(CoinRepository.getInstance().updateVolume(coinName, quantity,"SELL"))
        {



            MyLogger.customLogger("Coin sold successfully", Constants.INFO_LOGGER);
            Double costPrice = trader.removeCoin(coinName,quantity);
            MyLogger.customLogger("Cost price and quantity:"+costPrice/quantity+" "+quantity,Constants.INFO_LOGGER);
            Double intermediateProfitLoss = (CoinRepository.getInstance().getCoinPrice(coinName)-costPrice);
            MyLogger.customLogger("Selling price: "+CoinRepository.getInstance().getCoinPrice(coinName),Constants.INFO_LOGGER);
            Double netProfitLoss = trader.getNetProfit() + intermediateProfitLoss ;

            trader.setNetProfit(netProfitLoss);
           
            return true;
        }
        else
        {
            MyLogger.customLogger("Error in selling the coin. ", Constants.ERROR_LOGGER);
            return false;
        }

        
    }

}
