package org.models;
import java.util.Objects;
import java.util.Random;

public class Transaction {
    private String coin;
    private String coinSymbol;
    private String traderId;
    private TransactionType type;
    private double quantity;
    private String walletAddress;
    private double amount;  // To be used for price in UPDATE_PRICE transactions
    private boolean isPending;
    private String transactionHash;
    public Transaction(String coin, TransactionType type, double quantity, String walletAddress) {
        this.coin = coin;
        this.type = type;
        this.quantity = quantity;
        this.walletAddress = walletAddress;
    }

    public Transaction(String coin, TransactionType type, double amount) {
        this.coin = coin;
        this.type = type;
        this.amount = amount;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "coin='" + coin + '\'' +
                ", type=" + type +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }
    public void markAsPending(){
        this.isPending=true;
        this.transactionHash=getBlockHash();
    }

    public String getTraderId() {
        return traderId;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }
    @Override
    public boolean equals(Object o){
        if (this==o)
            return true;
        if (o==null||getClass()!=o.getClass())
            return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount)==0 &&
                isPending== that.isPending() &&
                Objects.equals(traderId,that.traderId) &&
                Objects.equals(coinSymbol,that.coinSymbol) &&
                type==that.type &&
                Objects.equals(transactionHash,that.transactionHash);
    }
    @Override
    public int hashCode(){
        return Objects.hash(traderId,coinSymbol,type,amount,isPending,transactionHash);
    }
    public String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();

        // Introducing delay mimicking complex calculation being performed.
        for (double i = 0; i < 1/*99999999*/; i++) {
            i = i;
        }

        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }

        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }

}
