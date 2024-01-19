package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvLoader {
    private static List<String[]> records = new ArrayList<>();
    public static Map<String, Player>loadCsv(String pathToCsv) {
        Map<String, Player> players = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(pathToCsv))){
            String line;
            int linenumber = 0;
            while((line = br.readLine()) != null){
                if(linenumber == 0){
                    linenumber++;
                    continue;
                }
                String[] values = line.split(",");
                records.add(values);
                String name = values[0];
                String team = values[1];
                String role = values[2];
                int matches = Integer.parseInt(values[3]);
                int runs = Integer.parseInt(values[4]);
                double average = Double.parseDouble(values[5]);
                double strikeRate = Double.parseDouble(values[6]);
                int wickets = Integer.parseInt(values[7]);
                Player player = new Player(name, team, role, matches, runs, average, strikeRate, wickets);
                players.put(name, player);
            }
        }catch(IOException e){
            Log.logger.error(e.getMessage());
        }
        return players;
    }
}
