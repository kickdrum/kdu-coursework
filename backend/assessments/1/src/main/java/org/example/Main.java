package org.example;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static org.example.Teams.*;
import static org.example.Tournament.*;


public class Main {
    public static ArrayList<Player> players = new ArrayList<>();


    public static void main(String[] args) throws CsvValidationException {
        int ind=0;
        //parsing CSV  files
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/IPL_2021-data.csv"))) {

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if(ind==0){
                    ind   ++;
                    continue;
                }
                ArrayList<String> row = new ArrayList<>();
                for (String value : nextLine) {
                    row.add(value);
                }
                Player player=new Player(row.get(0), row.get(1), row.get(2), Integer.parseInt(row.get(3).trim()), Integer.parseInt(row.get(4)), Double.parseDouble(row.get(5)), Double.parseDouble(row.get(6)), Integer.parseInt(row.get(7)));
//                System.out.println(player);

                updateTeam(player);
                players.add(player);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The PLayers are:");
        System.out.println();


        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName());
        }
        System.out.println("The teams are:");
        teams.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println();


        System.out.println("Bowlers with more than 40 wickets are:");
        atleast40Wicktes();

        System.out.println();
        System.out.println("These are the Highest Wickets and Most Runs for a team:");
        topPerformers("KKR");






    }


}