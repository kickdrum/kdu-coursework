package org.handson;

import javax.swing.*;

public class Player {
private String playerName;
private Integer runsScored;
private Integer wicketsTaken;

private String role;

private Integer matches;
private Integer runs;
private Double average;
private Integer wickets;
private Double SR;
Player(String name,String role,Integer matches,Integer runs,Double average,Double SR,Integer wickets)
{
    this.playerName = name;
    this.role = role;
    this.average=average;
    this.SR=SR;
    this.runs = runs;
    this.matches=matches;
    this.wickets =wickets;

}


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public Integer getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(Integer wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Double getSR() {
        return SR;
    }

    public void setSR(Double  SR) {
        this.SR = SR;
    }
    @Override
    public String toString()
    {
        return playerName+" "+role+" "+matches+" "+runs+" "+average+" "+SR+" "+wickets;
    }
}
