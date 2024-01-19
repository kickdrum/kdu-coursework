package org.handson;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players = new ArrayList<>();
    private String teamName;
    Team(String teamName)
    {
        this.teamName=teamName;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void addPlayer(String name, String role, Integer matches, Integer runs, Double average, Double SR, Integer wickets)
    {
        Player player = new Player(name,role,matches,runs,average,SR,wickets);
        players.add(player);
    }
    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public ArrayList<String> getBowlers()
    {
        ArrayList<String> bowlers = new ArrayList<>();
        for(Player player:players)
        {
            if(player.getRole().equals("BOWLER") && player.getWickets()>=40)
            {
                bowlers.add(player.getPlayerName());
            }
        }
        return bowlers;
    }
    public Player  maximumWickets()
    {
        int maxWickets = 0;
        Player playerMax = null;
        for(Player player:players)
        {
            if(player.getWickets()>maxWickets)
            {
                maxWickets = player.getWickets();
                playerMax = player;
            }
        }
        return playerMax;
    }
    public Player maximumRuns()
    {
        int maxRuns = 0;
        Player playerMax = null;
        for(Player player:players)
        {
            if(player.getRuns()>maxRuns)
            {
                maxRuns = player.getRuns();
               playerMax = player;
            }
        }
        return playerMax;
    }
}
