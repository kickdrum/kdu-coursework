package org.example;

import java.util.HashMap;

public class Team {

    String player_name;
    String team_name;
    String role;
    int matches;
    int runs;
    double average;
    double strikeRate;
    int wickets;
    Team(String player_name, String team_name, String role, int matches, int runs, double average, double strikeRate, int wickets){
        this.player_name = player_name;
        this.team_name = team_name;
        this.role = role;
        this.matches = matches;
        this.runs = runs;
        this.average =average;
        this.strikeRate = strikeRate;
        this.wickets = wickets;
    }

    public String getTeam_name() {
        return team_name;
    }

    public int getWickets() {
        return wickets;
    }

    public String getRole() {
        return role;
    }

    public String getPlayer_name() {
        return player_name;
    }
}
