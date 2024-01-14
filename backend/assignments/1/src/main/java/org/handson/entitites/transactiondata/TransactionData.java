package org.handson.entitites.transactiondata;

public interface TransactionData {

    public String getType();
    public void setType(String type);
    public String getCoinName();
    public void setCoinName(String coinName);
    public boolean performTransaction();
}