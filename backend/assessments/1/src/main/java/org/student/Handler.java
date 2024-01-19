package org.student;

import java.util.*;
import java.util.stream.Collectors;

public class Handler {
    public static void fortyWickets(String teamName, Map<String,List<Player>> teams){
        List<Player> players = teams.get(teamName);

        players.stream()
                .filter(player -> player.getWickets() > 40)
                .forEach(player -> Logging.logInfo(player.getName()));
    }

    public static void topOfTeam(String teamName, Map<String,List<Player>> teams){
        List<Player> players = teams.get(teamName);

        Player wicketHighest = players.stream()
                .max(Comparator.comparing(Player::getWickets))
                .orElseThrow(NoSuchElementException::new);

        Player runHighest = players.stream()
                .max(Comparator.comparing(Player::getRuns))
                .orElseThrow(NoSuchElementException::new);

        Logging.logInfo(String.format("Highest wicket taker : %s, Highest run getter : %s",
                wicketHighest.getName(),runHighest.getName()));
    }

    public static void top3Season(Map<String,List<Player>> teams){
        List<Player> top3 = new ArrayList<>();

        for(List<Player> players : teams.values()){
            for(Player player : players){
                top3.add(player);
            }
        }

        List<Player> top3Run = top3.stream()
                .sorted(Comparator.comparing(Player::getRuns).reversed())
                .limit(3)
                .toList();

        List<Player> top3Wicket = top3.stream()
                .sorted(Comparator.comparing(Player::getWickets).reversed())
                .limit(3)
                .toList();

        Logging.logInfo("Top 3 Runs ");
        top3Run.forEach(player -> Logging.logInfo(player.getName()));
        Logging.logInfo("Top 3 Wickets ");
        top3Wicket.forEach(player -> Logging.logInfo(player.getName()));


    }
}
