package org.example;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Player> players = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        players = CsvLoader.loadCsv("src/main/resources/IPL_2021-data.csv");
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            UserInterface.displayMenu();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    Log.logger.info("Enter the team");
                    scanner.nextLine();
                    String teamName = scanner.next();
                    UserInterface.displayPlayersWithAtleast40Wickets(teamName, players);
                    break;
                }
                case 2: {
                    Log.logger.info("Enter the team");
                    scanner.nextLine();
                    String teamName = scanner.next();
                    UserInterface.displayTopBatsmanBowlerByTeam(teamName, players);
                    break;
                }
                case 3: {
                    UserInterface.displayTopRunScorer(players);
                    break;
                }
                case 4: {
                    UserInterface.displayTopWicketTaker(players);
                    break;
                }
                case 5: {
                    String[] teams = players.values().stream()
                            .map(Player::getTeam)
                            .distinct()
                            .toArray(String[]::new);
                    UserInterface.writeFixturesToCSV(teams);
                    break;
                }
                case 6: {
                    exit = true;
                    break;
                }
                default: {
                    Log.logger.warn("Invalid choice");
                }
            }
        }


    }


}