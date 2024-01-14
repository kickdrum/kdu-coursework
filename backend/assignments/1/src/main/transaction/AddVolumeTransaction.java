package backend.assignment.transaction;

import backend.assignment.Market;
import backend.assignment.logging.LogBack;

public class AddVolumeTransaction implements Transaction{
    private Market market;
    private String type;
    private String coinName;
    private long volume;

    public AddVolumeTransaction(long volume,Market market)
    {
        this.volume = volume;
        this.market = market;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

    @Override
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    @Override
    public boolean executeTransaction() {
      boolean isSuccessful = market.updateVolume(this.coinName,this.volume);
        if(isSuccessful)
        {
            LogBack.infoLogger("Coin Volume added Successfully!");}
        else {
            LogBack.debugLogger("Coin Volume not added");
        }
            return isSuccessful;
    }
}
