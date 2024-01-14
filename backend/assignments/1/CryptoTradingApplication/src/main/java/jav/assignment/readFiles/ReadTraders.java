package jav.assignment.readFiles;


import jav.assignment.traders.Trader;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class ReadTraders {
    private static final String CSV_SEPARATOR = ",";

    public static void readDataFromTraders(HashMap<String, Trader> tradersData, List<Trader> allTradersList) throws IOException {

        String tradersCSV = "src/main/resources/traders.csv";
        BufferedReader br = null;
        try {
            File file = new File(tradersCSV);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String[] headerLine = br.readLine().split(CSV_SEPARATOR);
            String[] individualField;
//            line = br.readLine();
            while ((line = br.readLine()) != null) {
                individualField = line.split(CSV_SEPARATOR);
                Trader trader = new Trader();
                trader.setSrNo(Integer.parseInt(individualField[0]));
                trader.setFirstName(individualField[1]);
                trader.setLastName(individualField[2]);
                trader.setPhone(individualField[3]);
                trader.setWalletAddress(individualField[4]);

                tradersData.put(trader.getWalletAddress(), trader);
                allTradersList.add(trader);
            }
            System.out.println("Traders data read");

        } catch(NumberFormatException numberFormatException) {
            throw new NumberFormatException("Problem occurred while parsing data, check whether correct typecasting is being used for data type");
        } catch(FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("The file you are looking doesn't exist at location, Please check its file path or name");
        } catch (IOException ioException) {
            throw new IOException("Problem occurred while reading file, check for file security, permission or your network ");
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