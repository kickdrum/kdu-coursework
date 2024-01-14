package org.handson.entitites.repositories;

import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.handson.Constants;
import org.handson.entitites.concrete.Coins;
import com.opencsv.*; 

import org.handson.logger.MyLogger;
class DescendingComparator implements Comparator<Coins> {
    @Override
    public int compare(Coins a, Coins b) {
        return Double.compare(Double.parseDouble(b.getPrice()), Double.parseDouble(a.getPrice()));
    }
}
public class CoinRepository {
    private static HashMap<String, Coins> coinMap = new HashMap<>();
    private static CoinRepository instance = new CoinRepository();

    private CoinRepository() {
    }

    public static synchronized CoinRepository getInstance() {
        if(instance == null)
        {
            instance = new CoinRepository();
        }
        return instance;
    }
    public synchronized boolean updateCoinPrice(String coinName, Double price) {
       try{
        Coins coinsObj = coinMap.get(coinName);
        coinsObj.setPrice(price.toString());
        return true;
       }
        catch(Exception e)
        {
            MyLogger.customLogger(e.toString(), Constants.ERROR_LOGGER);
            return false;
        }
    }

    public Double getCoinPrice(String coin) {
        Coins coinsObj = coinMap.get(coin);
        if (coinsObj == null) {
            MyLogger.customLogger("Coin not found, Coin Object empty" + coin, Constants.ERROR_LOGGER);
            return null;
        } else {
            MyLogger.customLogger("Coin found " + coinsObj.getCoinSymbol() + " " + coinsObj.getPrice(), Constants.INFO_LOGGER);
        }

        return Double.parseDouble(coinsObj.getPrice());
    }

    public boolean updateVolume(String coinName, long volume, String buyOrSell) {
        Coins coinsObj = coinMap.get(coinName);
        if (coinsObj == null) {
            MyLogger.customLogger("Coin not found" + coinName, Constants.ERROR_LOGGER);
            return false;
        } else {
            MyLogger.customLogger("Coin found", Constants.INFO_LOGGER);
            String hexadecimalPart = coinsObj.getCirculatingSupply();
             Long volumeInteger = Long.parseLong(hexadecimalPart);
             Long updatedVolume;
    
            synchronized (coinsObj) {
                if (buyOrSell.equals("BUY"))
                    updatedVolume = volumeInteger -  volume;
                else
                    updatedVolume = volumeInteger +  volume;
    
                while (updatedVolume < 0 || updatedVolume>Long.parseLong(coinsObj.getInitialCoinValue())) {
                    try {
                        if (updatedVolume < 0) {
                            MyLogger.customLogger("Volume is insufficient. Waiting for update...", Constants.INFO_LOGGER);
                        } else {
                            MyLogger.customLogger("Volume exceeds the initial coin value. Waiting for update...", Constants.INFO_LOGGER);
                        }                        
                        coinsObj.wait();
                        updatedVolume = Long.parseLong(coinsObj.getCirculatingSupply().substring(2));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        MyLogger.customLogger("Interrupted while waiting for volume update.", Constants.ERROR_LOGGER);
                        return false;
                    }
                }
    
                String updatedVolumeString = updatedVolume.toString();
                coinsObj.setCirculatingSupply(updatedVolumeString);
                coinsObj.notifyAll();
            }
    
            return true;
        }
    }

    public void showTopNCoins(int n) {
        List<Coins> topNCoins = coinMap.values()
                .stream()
                .sorted(new DescendingComparator())
                .limit(n)
                .toList();

        MyLogger.customLogger("Top " + n + " Coins:", Constants.INFO_LOGGER);

        topNCoins.forEach(coin -> MyLogger.customLogger(coin.toString(), Constants.INFO_LOGGER));
    }
    public void displayCoinDetails(String name)
    {
        Coins coins = coinMap.get(name);
        if(coins == null)
        {
            MyLogger.customLogger("Coin not found"+ name,Constants.ERROR_LOGGER);
        }
        else
        {
            MyLogger.customLogger(coins.toString(),Constants.INFO_LOGGER);
        }
    }
    /**
     * Loads data from a CSV file and populates the coinMap.
     *
     * @return None
     */
    public synchronized void load() {
        String fileName = Constants.FILE_COIN_CSV;
        

        try( CSVReader reader = new CSVReader(new FileReader(fileName))) {
           
            reader.readNext();
            List<String[]> csvData = reader.readAll();


            for (String[] row : csvData) {
                String rank = row[1];
                String name = row[2];
                String symbol = row[3];
                String price = row[4];
                String circulatingSupply = row[5];


                Coins coins = new Coins();

                coins.setRank(rank);
                coins.setCoinName(name);
                coins.setSymbol(symbol);
                coins.setPrice(price);
                coins.setCirculatingSupply(circulatingSupply);
                coinMap.put(symbol, coins);

                MyLogger.customLogger(coins.toString(), Constants.DEBUG_LOGGER);
                
            }
            MyLogger.customLogger("Coins loaded successfully.", Constants.INFO_LOGGER);
        } catch (Exception e) {
            MyLogger.customLogger("Error loading coins from CSV: " + e.getMessage(), Constants.ERROR_LOGGER);
        } 
    }
}
