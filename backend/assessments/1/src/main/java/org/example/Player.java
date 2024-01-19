package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private String team;
    private String role;
    private int matches;
    private int runs;

    private double sr;
    private double average;
    private int wickets;

    public Player(String name, String team, String role, int matches, int runs, double average, double sr, int wickets)
    {
        this.name = name;
        this.team = team;
        this.role = role;
        this.matches = matches;
        this.runs = runs;
        this.average = average;
        this.sr = sr;
        this.wickets = wickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getSr() {
        return sr;
    }

    public void setSr(double sr) {
        this.sr = sr;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }



}
