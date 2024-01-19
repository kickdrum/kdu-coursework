package org.example;
import org.example.LoggerClass;

import org.example.LoggerClass;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<String> get40Players(String teamName, List<Player> players)
    {
        List<String> playerNames = new ArrayList<>();
        for(Player player: players)
        {
            if(player.getTeam().equals(teamName) && player.getWickets()>=40)
            {
                playerNames.add(player.getName());
            }
        }

        return playerNames;
    }

    public static String getHighestWicketTaker(String teamName, List<Player> players)
    {
        int highestWickets = 0;
        String highestWicketTaker = "";
        for(Player player: players)
        {
            if(player.getWickets() > highestWickets && player.getTeam().equals(teamName))
            {
                highestWickets = player.getWickets();
                highestWicketTaker = player.getName();
            }
        }

        return highestWicketTaker;
    }

    public static String getHighestSingleWicketTaker(List<Player> players)
    {
        int highestWickets = 0;
        String highestWicketTaker = "";
        for(Player player: players)
        {
            if(player.getWickets() > highestWickets)
            {
                highestWickets = player.getWickets();
                highestWicketTaker = player.getName();
            }
        }

        return highestWicketTaker;
    }

    public static List<String> getTop3WicketTakers(List<Player> players)
    {
        List<String> playerNames = new ArrayList<>();
        String player1 = getHighestSingleWicketTaker(players);
        players.removeIf(player -> player.getName().equals(player1));

        String player2 = getHighestSingleWicketTaker(players);
        players.removeIf(player -> player.getName().equals(player2));
        String player3 = getHighestSingleWicketTaker(players);


        playerNames.add(player1);
        playerNames.add(player2);
        playerNames.add(player3);

        return playerNames;
    }

    public static String getHighestSingleRunScorer(List<Player> players)
    {
        int highestWickets = 0;
        String highestWicketTaker = "";
        for(Player player: players)
        {
            if(player.getRuns() > highestWickets)
            {
                highestWickets = player.getRuns();
                highestWicketTaker = player.getName();
            }
        }

        return highestWicketTaker;
    }

    public static List<String> getTop3RunScorers(List<Player> players)
    {
        List<String> playerNames = new ArrayList<>();
        String player1 = getHighestSingleRunScorer(players);
        players.removeIf(player -> player.getName().equals(player1));

        String player2 = getHighestSingleRunScorer(players);
        players.removeIf(player -> player.getName().equals(player2));
        String player3 = getHighestSingleRunScorer(players);


        playerNames.add(player1);
        playerNames.add(player2);
        playerNames.add(player3);

        return playerNames;
    }

    public static void main(String[] args) throws Exception {
        LoggerClass logger = new LoggerClass();
        CSVToObjectConverter csvToObjectConverter = new CSVToObjectConverter();


//        CSVReader csvReader = new CSVReader();
        Scanner scanner = new Scanner(System.in);
//        csvReader.parseCSV();
        while (true) {

            logger.getLoggerOutput("1. Return all bowlers who have taken at least 40 wickets", "info");
            logger.getLoggerOutput("2. Display the details of the highest wicket-taker and highest run-scorer", "info");
            logger.getLoggerOutput("3. Fetch the top 3 run-scorer and top 3 wicket-takers of the season", "info");
            logger.getLoggerOutput("4. Exit", "info");
            logger.getLoggerOutput("Enter your choice: ", "info");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    logger.getLoggerOutput("Enter team name: ", "info");
                    String teamName = scanner.next();
                    List<Player> players = csvToObjectConverter.getCSV();
                    List<String> playerOutput = get40Players(teamName, players);
                    for(String playerName: playerOutput)
                    {
                        logger.getLoggerOutput(playerName, "info");
                    }
                    break;
                case 2:
                    logger.getLoggerOutput("Enter team name:", "info");
                    String teamName2 = scanner.next();
                    List<Player> players2 = csvToObjectConverter.getCSV();
                    String playerOutput2 = getHighestWicketTaker(teamName2, players2);
                    logger.getLoggerOutput(playerOutput2, "info");
                    break;
                case 3:
                    logger.getLoggerOutput("The top 3 of the season are:", "info");
                    List<Player> players3 = csvToObjectConverter.getCSV();
                    List<String> top3Wicket = getTop3WicketTakers(players3);
                    List<Player> players4 = csvToObjectConverter.getCSV();
                    List<String> top3Runs = getTop3RunScorers(players4);
                    logger.getLoggerOutput("Top 3 wicket keepers of the season: ", "info");
                    for(String ele: top3Wicket)
                    {
                       logger.getLoggerOutput(ele, "info");
                    }
                    logger.getLoggerOutput("Top 3 run scorers of the season: ", "info");
                    for(String ele: top3Runs)
                    {
                        logger.getLoggerOutput(ele, "info");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    logger.getLoggerOutput("Invalid choice. Please enter a valid option.", "info");
            }
        }
    }
}