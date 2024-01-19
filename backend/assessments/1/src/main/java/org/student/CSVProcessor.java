package org.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CSVProcessor {

    private CSVProcessor(){}

    public static Map<String, List<Player>> readCSV(String path){
        Map<String, List<Player>> team = new HashMap<>();
        boolean firstLine = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(firstLine){
                    firstLine = false; continue;
                }
                String name = values[0];
                String teamName = values[1];
                String role = values[2];
                int matches = Integer.parseInt(values[3]);
                int runs = Integer.parseInt(values[4]);
                double average = Double.parseDouble(values[5]);
                double strikeRate = Double.parseDouble(values[6]);
                int wickets = Integer.parseInt(values[7]);

                Player player = new Player(name,role,matches,runs,average,strikeRate,wickets);
                if(team.get(teamName) == null){
                    List<Player> players = new ArrayList<>();
                    players.add(player);
                    team.put(teamName,players);
                }
                else{
                    List<Player> players = team.get(teamName);
                    players.add(player);
                    team.put(teamName,players);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return team;
    }

}