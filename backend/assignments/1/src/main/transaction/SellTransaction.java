package backend.assignment.transaction;

import backend.assignment.Market;
import backend.assignment.logging.LogBack;

public class SellTransaction implements Transaction{
    private String type;
    private String coinName;
    private long quantity;
    private String walletAddress;
    private Market market;

    public SellTransaction(long quantity,String walletNumber,Market market){
        this.quantity = quantity;
        this.walletAddress = walletNumber;
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
        boolean isSuccessfull = market.sellCoin(walletAddress,coinName,quantity);
        if(isSuccessfull)
        {
            LogBack.infoLogger("Coin Sold Successfully!");}
        else {
            LogBack.debugLogger("Coin not sold");
        }
        return isSuccessfull;
    }
}
