package org.example;

import java.util.ArrayList;

public class Player {
    private String name;
    private String team;
    private String role;
    private int matches;
    private Integer runs;
    private Double average;
    private Double strikeRate;
    private Integer wickets;

    public Player(String name, String team, String role, Integer matches, Integer runs, Double average, Double strikeRate, Integer wickets)
    {
        this.name=name;
        this.team=team;
        this.role=role;
        this.matches=matches;
        this.runs=runs;
        this.average=average;
        this.strikeRate=strikeRate;
        this.wickets=wickets;
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getMatches() {
        return matches;
    }

    public String getRole() {
        return role;
    }

    public Integer getRuns() {
        return runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public Double getAverage() {
        return average;
    }
    public Double getStrikeRate(){
        return strikeRate;
    }

}
