package org.handson;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.handson.logging.MyLogger;

import com.opencsv.CSVWriter;

class DescComparatorWickets implements Comparator<Player>
{
    public int compare(Player a,Player b)
    {
        return b.getWickets()-a.getWickets();
    }
}
class DescComparatorRuns implements Comparator<Player>
{
    public int compare(Player a,Player b)
    {
        return b.getRuns()-a.getRuns();
    }
}
public class Season {
    private HashMap<String,Team> teams = new HashMap<>();
    public  Team addTeam(String teamName)
    {
        MyLogger.customLogger("teamname is "+teamName, "INFO");
        if(teams.get(teamName)!=null)
        {
            MyLogger.customLogger("Team name already exists. Adding player", "DEBUG");
            return teams.get(teamName);
        }
        MyLogger.customLogger("Adding team and Adding player", "DEBUG");

        Team teamObj = new Team(teamName);
        teams.put(teamName,teamObj);
        return teamObj;

    }
    public Team getTeam(String teamName)
    {
        return teams.get(teamName);
    
    }
    public ArrayList<Player> getTop3WithHighestWicketTaker()
    {
       
        List<Player> top = new ArrayList<>();
       for(Team team:teams.values())
       {
          Player p =  team.maximumWickets();
          top.add(p);
       }
       Collections.sort(top,new DescComparatorWickets());
       ArrayList<Player> top3 = new ArrayList<>();
       top3.add(top.get(0));
       top3.add(top.get(1));
       top3.add(top.get(2));
       return top3;

    }
public ArrayList<Player> getTeamWithHighestScoreRunner()
{
    List<Player> top = new ArrayList<>();
    for(Team team:teams.values())
    {
       Player p =  team.maximumRuns();
       top.add(p);
    }
    Collections.sort(top,new DescComparatorRuns());
    ArrayList<Player> top3 = new ArrayList<>();
    top3.add(top.get(0));
    top3.add(top.get(1));
    top3.add(top.get(2));
    return top3;
}
public void createMatchFixtures()
{
    int matchNumber = 1;
    HashMap<String,Integer> teamMapPlayedEachotherCount = new HashMap<>();
    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_MONTH,16);
    c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
    c.set(Calendar.MONTH,Calendar.JANUARY);
    c.set(Calendar.YEAR,2023);
    String outputCSVFile = "src/main/java/org/handson/output.csv";
    String[] times = {"6:30pm","9:30pm"};
    try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputCSVFile))) {
        int index=0;
        Double r  = Math.random();
     
        ArrayList<Team> teamNames = new ArrayList<Team>(teams.values());
        int randomIndex = (int)(r*(teamNames.size()));

        int totalcount  = 0;
        while(totalcount<=Math.pow(2,teamNames.size()))
        {
            r  = Math.random();
            randomIndex = (int)(r*(teamNames.size()));
            Team team = teamNames.get(randomIndex);
            MyLogger.customLogger(team.getTeamName(), "DEBUG");
            
             r  = Math.random();
             randomIndex = (int)(r*(teamNames.size()));
             Team team2 = teamNames.get(randomIndex);
             MyLogger.customLogger(team2.getTeamName(),"DEBUG");
             if(!team.getTeamName().equals(team2.getTeamName()) &&teamMapPlayedEachotherCount.get(team.getTeamName()+"_"+team2.getTeamName())==null)
             {
                 
                 teamMapPlayedEachotherCount.put(team.getTeamName()+"_"+team2.getTeamName(),1);
                 String[] data = {c.getTime()+" "+times[index]+"",matchNumber+"",team.getTeamName(),team2.getTeamName(),team.getTeamName()+"_home"};
                 csvWriter.writeNext(data);
                 totalcount++;
             }
             else{
                continue;
             }
             if(index==1)
             {
                 index=0;
                 c.add(Calendar.DAY_OF_MONTH,1);
             }
             else
             {
                 index=1;
             }
             matchNumber++;
        }
       
   
}
catch(Exception e)
{
    MyLogger.customLogger(e.toString(), "ERROR");
}

}
}

