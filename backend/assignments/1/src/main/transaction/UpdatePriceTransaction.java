package backend.assignment.transaction;

import backend.assignment.Market;
import backend.assignment.logging.LogBack;

public class UpdatePriceTransaction implements Transaction{
    private String type;
    private String coinName;
    private double price;
    private Market market;

    public UpdatePriceTransaction(double price , Market market){
        this.price = price;
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
        boolean isSuccessful = market.updateCoinPrice(coinName,price);
        if(isSuccessful)
        {
            LogBack.infoLogger("Updated Coin price Successfully!");}
        else {
            LogBack.debugLogger("Coin Price couldn't be updated ");
        }
        return isSuccessful;
    }
}
