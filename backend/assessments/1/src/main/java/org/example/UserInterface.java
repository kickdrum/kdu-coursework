package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class UserInterface {
    private UserInterface() {
    }
    public static void displayMenu(){
        Log.logger.info("Welcome to IPL Analyser");
        Log.logger.info("Enter the choice");
        Log.logger.info("1. Display the player with more than 40 wickets by team");
        Log.logger.info("2. Display the best batsman and bowler details by team");
        Log.logger.info("3. Display the top 3 run scorer of the season");
        Log.logger.info("4. Display the top 3 wicket taker of the season");
        Log.logger.info("5. Display fixtures");
        Log.logger.info("6. Exit");
    }
    public static void displayPlayersWithAtleast40Wickets(String teamName, Map<String, Player> players){
        Log.logger.info("Players with atleast 40 wickets are");
        players.values().stream()
                .filter(player -> player.getTeam().equals(teamName))
                .filter(player -> player.getWickets() >= 40)
                .forEach(player -> Log.logger.info(player.getName()));
    }
    public static void displayTopBatsmanBowlerByTeam(String teamName, Map<String, Player> players){
        Log.logger.info("Best batsman details are");
        players.values().stream()
                .filter(player -> player.getTeam().equals(teamName))
                .sorted((player1, player2) -> player2.getRuns() - player1.getRuns())
                .limit(1)
                .forEach(player -> Log.logger.info("Best batsman is {} with {} runs", player.getName(), player.getRuns()));

        Log.logger.info("Best bowler details are");
        players.values().stream()
                .filter(player -> player.getTeam().equals(teamName))
                .sorted((player1, player2) -> player2.getWickets() - player1.getWickets())
                .limit(1)
                .forEach(player -> Log.logger.info("Best bowler is {} with {} wickets", player.getName(), player.getWickets()));

    }
    public static void displayTopRunScorer(Map<String, Player> players){
        Log.logger.info("Top 3 run scorer of the season details are");
        players.values().stream()
                .sorted((player1, player2) -> player2.getRuns() - player1.getRuns())
                .limit(3)
                .forEach(player -> Log.logger.info("{} with {} runs", player.getName(), player.getRuns()));
    }
    public static void displayTopWicketTaker(Map<String, Player> players){
        Log.logger.info("Top 3 wicket taker of the season details are");
        players.values().stream()
                .sorted((player1, player2) -> player2.getWickets() - player1.getWickets())
                .limit(3)
                .forEach(player -> Log.logger.info("{} with {} wickets", player.getName(), player.getWickets()));
    }
    /*Take input of team names and generate the match fixtures such that each team plays
every other team twice (at home and away), with a maximum of 2 matches per day, and
write it to a CSV file.*/
    public static void writeFixturesToCSV(String[] teams) throws FileNotFoundException {
        Log.logger.info("Fixtures are written to CSV file");
        Date startdate = new Date();
        String time1 = "6.30 PM";
        String time2 = "9.30 PM";
        int numberOfTeams = teams.length;
        int matchNumber = 1;
        Map<String, String[]> fixtureOfSingleTeam = new HashMap<>();
        for(int i = 0; i < numberOfTeams; i++){
            String[] fixture = new String[numberOfTeams - 1];
            int k = 0;
            for(int j = 0; j < numberOfTeams; j++){
                if(i != j){
                    fixture[k++] = teams[j];
                }
            }
            fixtureOfSingleTeam.put(teams[i], fixture);
        }
        try {
            File file = new File("src/main/resources/fixtures.csv");
            PrintWriter pw = new PrintWriter(file);
            pw.append("Date,Time,Match Number,Team home,Team away,Ground");
            pw.append("\n");
            for (String team : teams) {
                String[] fixture = fixtureOfSingleTeam.get(team);
                for (int j = 0; j < numberOfTeams - 1; j++) {
                    if (matchNumber % 2 == 0) {
                        pw.append(String.valueOf(startdate)).append(",").append(time2).append(",").append(String.valueOf(matchNumber)).append(",").append(team).append(",").append(fixture[j]).append(",").append("Chennai");
                        pw.append("\n");
                    } else {
                        pw.append(String.valueOf(startdate)).append(",").append(time1).append(",").append(String.valueOf(matchNumber)).append(",").append(team).append(",").append(fixture[j]).append(",").append("Mumbai");
                        pw.append("\n");
                    }
                    matchNumber++;
                }
            }
        }
        catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File not found");
        }

    }
}
