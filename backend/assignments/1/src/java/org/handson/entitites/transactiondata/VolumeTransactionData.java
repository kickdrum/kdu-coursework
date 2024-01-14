package org.handson.entitites.transactiondata;

import org.handson.Constants;
import org.handson.entitites.repositories.CoinRepository;
import org.handson.logger.MyLogger;

public class VolumeTransactionData implements TransactionData {
    private String type;
    private String coinName;
    private long volume;
    public VolumeTransactionData(long volume)
    {
        this.volume = volume;
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
      public boolean performTransaction()
    {
        boolean isSuccessful = CoinRepository.getInstance().updateVolume(coinName, volume, "UPDATEPRICE");
        if(isSuccessful)
        {
            MyLogger.customLogger("Coin volume updated successfully", Constants.INFO_LOGGER);
        }
        else
        {
            MyLogger.customLogger("Error in updating the volume", Constants.ERROR_LOGGER);

        }
       return isSuccessful;
    }
}
