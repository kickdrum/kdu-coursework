package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjectConverter {
    public List<Player> getCSV() {
        String csvFile = "src/main/resources/IPL_2021-data.csv";
        String line;
        String csvSplitBy = ",";

        List<Player> players = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String name = data[0];
                String team = data[1];
                String role = data[2];
                int matches = Integer.parseInt(data[3]);
                int runs = Integer.parseInt(data[4]);
                double average = Double.parseDouble(data[5]);
                double sr = Double.parseDouble(data[6]);
                int wickets = Integer.parseInt(data[7]);

                Player player = new Player(name, team, role, matches, runs, average, sr, wickets);
                players.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        for (Player player: players) {
//            System.out.println(player.getWickets());
//        }

        return players;
    }
}
