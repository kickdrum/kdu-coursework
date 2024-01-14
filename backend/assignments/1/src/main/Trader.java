package backend.assignment;

import backend.assignment.logging.LogBack;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String walletAddress;
    private Map<String,PortfolioEntry> portfolio;
    private double totalProfitLoss;

    Trader(String firstName,String lastName,String phoneNumber,String walletAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.walletAddress = walletAddress;
        this.totalProfitLoss = 0.0;
        this.portfolio = new HashMap<>();
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String newWalletAddress) {
        this.walletAddress = newWalletAddress;
    }

    public double getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(double gain){
        this.totalProfitLoss +=gain;
    }

    public Map<String, PortfolioEntry> getPortfolio() {
        return portfolio;
    }

    public void printPortfolio(){
        LogBack.infoLogger("Portfolio for: " + getFirstName() + getLastName());
        LogBack.infoLogger("Coin\tQuantity\tAverage Price");
        for(Map.Entry<String ,PortfolioEntry> entry: portfolio.entrySet()){
            PortfolioEntry portfolioEntry = entry.getValue();
            String output = String.format("%-10s\t%-10d\t%-10.2f%n",entry.getKey(), portfolioEntry.getQuantity(), portfolioEntry.getAveragePrice());
            LogBack.infoLogger(output);
        }
    }
    public synchronized void addCoinToPortfolio(String coinName,long quantity,double marketPrice){
        PortfolioEntry entry = this.portfolio.get(coinName);
        if(entry == null){
        entry = new PortfolioEntry();
        entry.setQuantity(quantity);
        entry.setAveragePrice(marketPrice);
        this.portfolio.put(coinName,entry);

        } else {
            double existingAveragePrice = this.portfolio.get(coinName).getAveragePrice();
            long existingQuantity = this.portfolio.get(coinName).getQuantity();
            entry.setQuantity(existingQuantity + quantity );
            double newAverage = (existingAveragePrice * existingQuantity + marketPrice * quantity)/(existingQuantity+quantity);
            entry.setAveragePrice(newAverage);
        }
    }

    public synchronized void removeCoinFromPortfolio(String coinName, long quantity) {
        PortfolioEntry entry = this.portfolio.get(coinName);

        if (entry == null) {
            // Handle the error gracefully and informatively:
            LogBack.debugLogger("Coin not found in portfolio: ");
            throw new IllegalArgumentException("Invalid coin: " + coinName);
        } else {
            long existingQuantity = entry.getQuantity();

            if (existingQuantity < quantity) {
                // Handle the error responsibly:
                LogBack.debugLogger("Insufficient quantity of coin in portfolio.");
                throw new IllegalArgumentException("Insufficient quantity of coin: " + coinName);
            } else {
                // Remove the specified quantity securely:
                entry.setQuantity(existingQuantity - quantity);

                if (entry.getQuantity() == 0) {
                    // Cleanup empty entries responsibly:
                    this.portfolio.remove(coinName);
                }
            }
        }
    }

    public static class PortfolioEntry{
        private long quantity;
        private double averagePrice;

        //Getters
        public long getQuantity() {
            return quantity;
        }

        public double getAveragePrice() {
            return averagePrice;
        }

        // Setters
        public synchronized void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public synchronized void setAveragePrice(double averagePrice) {
            this.averagePrice = averagePrice;
        }
    }



}
