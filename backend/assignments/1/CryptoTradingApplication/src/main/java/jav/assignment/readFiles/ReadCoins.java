package jav.assignment.readFiles;

import jav.assignment.Coins.Coin;

import java.io.*;
import java.util.HashMap;

public class ReadCoins {
    private static final String CSV_SEPARATOR = ",";

    public static void readDataFromCoins(String coinsCsvFilePath, HashMap<String, Coin> coinNameAndCoinObject, HashMap<String, Coin> coinSymbolAndCoinObject) throws IOException {

        String tradersCSV = "src/main/resources/coins.csv";
        BufferedReader br = null;
        try {
            File file = new File(tradersCSV);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String[] headerLine = br.readLine().split(CSV_SEPARATOR);
            String[] individualField;

            while ((line = br.readLine()) != null) {
                individualField = line.split(CSV_SEPARATOR);
                Coin coin = new Coin();
                coin.setSrNo(Integer.parseInt(individualField[0]));
                coin.setRank(Integer.parseInt(individualField[1]));
                coin.setName(individualField[2]);
                coin.setSymbol(individualField[3]);
                coin.setPrice(Double.valueOf(individualField[4]));
                coin.setCirculatingSupply(Long.parseLong(individualField[5]));
                coinNameAndCoinObject.put(coin.getName(), coin);
                coinSymbolAndCoinObject.put(coin.getSymbol(), coin);
            }
            System.out.println("Coins data read");

        } catch(NumberFormatException numberFormatException) {
            throw new NumberFormatException("Problem occured while parsing data, check whether correct typecasting is being used for data type");
        } catch(FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("The file you are looking doesn't exist at location, Please check its file path or name");
        } catch (IOException ioException) {
            throw new IOException("Problem occured while reading file, check for file security, persmission or your network ");
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close the reader resource, check for its availability");
                }
            }
        }
    }

}