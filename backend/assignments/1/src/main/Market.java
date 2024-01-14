package backend.assignment;

import backend.assignment.logging.LogBack;
import backend.assignment.util.Constants;
import backend.assignment.util.CsvUtil;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Market {
    Trader[] traders = new Trader[500];
    Coin[] coins = new Coin[400];
    Market() {
        CSVParser coinCsvParser = null;
        int coinCount = 0;
        try {
            coinCsvParser = CsvUtil.getCSVContent(
                    Constants.FILE_COIN_CSV
            );
        } catch (IOException e) {
            LogBack.debugLogger(e.getMessage());
        }
        if (coinCsvParser != null)
            for (CSVRecord csvRecord : coinCsvParser) {

                int rank = Integer.parseInt(csvRecord.get(1));
                String name = csvRecord.get(2);
                String symbol = csvRecord.get(3);
                double price = Double.parseDouble(csvRecord.get(4));
                long circulatingSupply = Long.parseLong(csvRecord.get(5));
                coins[coinCount] = new Coin(rank, name, symbol, price, circulatingSupply);
                coinCount++;
            }
        CSVParser tradersCsvParser = null;
        try {
            tradersCsvParser = CsvUtil.getCSVContent(Constants.FILE_TRADER_CSV);
        } catch (IOException e) {
            LogBack.debugLogger(e.getMessage());
        }

        int traderCount=0;
        if(tradersCsvParser != null) {
            for (CSVRecord csvRecord : tradersCsvParser) {

                String firstName = csvRecord.get(1);
                String lastName = csvRecord.get(2);
                String phoneNumber = csvRecord.get(3);
                String walletAddress = csvRecord.get(4);
                traders[traderCount] = new Trader(firstName, lastName, phoneNumber, walletAddress);
                traderCount++;
            }
        }
        try {
            assert coinCsvParser != null;
            coinCsvParser.close();
            assert tradersCsvParser != null;
            tradersCsvParser.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public void getTopNCoins (int n){
        if(n > coins.length){
            n = coins.length;
        }
        List<Coin> topNcoins= null;
            topNcoins = Arrays.stream(coins).sorted(Comparator.comparing(Coin::getRank).thenComparing(Coin::getName)).limit(n).toList();

        for (Coin item : topNcoins) {
            LogBack.infoLogger("Name: " + item.getName() + ", Price: " + item.getPrice());
        }
    }
    public Optional<Trader> findTraderByName(String name){
        return Arrays.stream(this.traders)
                .filter(trader -> trader.getFirstName().equalsIgnoreCase(name))
                .findFirst();

    }
    public Optional<Trader> findTraderByWalletAddress(String walletAddress){
        return Arrays.stream(this.traders)
                .filter(trader -> trader.getWalletAddress().equalsIgnoreCase(walletAddress))
                .findFirst();
    }
    public Optional<Coin> findCoinByName(String name){
        return Arrays.stream(this.coins)
                .filter(coin -> (coin.getName().equalsIgnoreCase(name)) || (coin.getSymbol().equalsIgnoreCase(name)))
                .findFirst();
    }
    public void getTopTradersByProfit(int n){
        List<Trader> topTraders= null;
        topTraders =  Arrays.stream(this.traders).sorted(Comparator.comparing(Trader::getTotalProfitLoss).reversed()).limit(n).toList();
        LogBack.infoLogger("Top " + n + " Traders by Profit");
        for (Trader trader : topTraders) {
            LogBack.infoLogger(trader.getFirstName() + ": $" + trader.getTotalProfitLoss());
        }
    }
    public void getTopTradersByLoss(int n){
        List<Trader> topTraders= null;
        topTraders =  Arrays.stream(this.traders).sorted(Comparator.comparing(Trader::getTotalProfitLoss)).limit(n).toList();
        LogBack.infoLogger("Top " + n + " Traders by Loss");
        for (Trader trader : topTraders) {
            LogBack.infoLogger(trader.getFirstName() + ": $" + trader.getTotalProfitLoss());
        }
    }
    public boolean updateCoinPrice(String coinName,Double updatedPrice){
        try {
            Coin coin = findCoinByName(coinName).orElse(null);
            if (coin != null){
                coin.setPrice(updatedPrice);
                return true;
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    public boolean updateVolume(String coinName,long volume){
        try{
            Coin coin = findCoinByName(coinName).orElse(null);
            if(coin!=null){
                coin.setCirculatingSupply(coin.getCirculatingSupply()+volume);
                return true;
            }
        } catch (Exception e){
            return false;
        }
        return false;

    }

    public synchronized boolean buyCoin(String walletAddress,String coinName,long quantity) throws InterruptedException {
        Trader trader = findTraderByWalletAddress(walletAddress).orElse(null);
        Coin marketCoin = findCoinByName(coinName).orElse(null);
        if(trader != null && marketCoin != null){
            long marketQuantity = marketCoin.getCirculatingSupply();
            while(marketQuantity < quantity){
                wait();
                marketQuantity = marketCoin.getCirculatingSupply();
            }
            trader.addCoinToPortfolio(marketCoin.getSymbol().toUpperCase(),quantity,marketCoin.getPrice());
            marketCoin.setCirculatingSupply(marketQuantity- quantity);
            notifyAll();
            return true;
        }
         return false;
    }

    public synchronized boolean sellCoin(String walletAddress,String coinName,long quantity){
        Trader trader =  findTraderByWalletAddress(walletAddress).orElse(null);
        Coin marketCoin = findCoinByName(coinName).orElse(null);
        if(trader != null && marketCoin != null && trader.getPortfolio().containsKey(marketCoin.getSymbol())){
            Trader.PortfolioEntry entry = trader.getPortfolio().get(marketCoin.getSymbol());
            if (entry.getQuantity() >= quantity) {
                marketCoin.setCirculatingSupply(marketCoin.getCirculatingSupply()+quantity);
                trader.setTotalProfitLoss((marketCoin.getPrice()-entry.getAveragePrice())* quantity);
                trader.removeCoinFromPortfolio(marketCoin.getSymbol(),quantity);
                notifyAll();

                return true;
            } else {
                LogBack.debugLogger("Not enough coins to sell in wallet");
                return false;
            }
        }
        LogBack.debugLogger("Trader not found or coin not found");
        return false;
    }

}
