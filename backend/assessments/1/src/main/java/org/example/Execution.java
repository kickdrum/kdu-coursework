package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.LoggerFactory;

public class Execution {
    LinkedList<Team> teamLinkedList=new LinkedList<>();// ArrayList giving error: cannot create arrayList

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Execution.class);
    public void print40Bowler(String teamName) {     //Can be bowler, all-rounder
        int wickets=40;
        logger.info("Bowler List: ");
        for(Team team:teamLinkedList){
            if(teamName.equals(team.getTeam_name())&&team.getWickets()>=wickets){
                logger.info(team.getPlayer_name());
            }
        }

        logger.info("");
    }

    public void printHighestPlayer(String teamName){      //Can be batsman, all-rounder
        String bowler ="";
        String batsman = "";
        logger.info("Team List");
        int runs=0;
        int wickets = 0;
        for(Team team:teamLinkedList){
            if(teamName.equals(team.getTeam_name())&&team.getWickets()>=wickets){
                bowler = team.getPlayer_name();
            }
        }
        for(Team team:teamLinkedList){
            if(teamName.equals(team.getTeam_name())&&team.getWickets()>=runs){
                batsman = team.getPlayer_name();
            }
        }
        logger.info("Bowler: ".concat(bowler));
        logger.info("Batsman: ".concat(batsman));
        logger.info("");
    }

    public void topPerformer(){
        LinkedList<Pair> topBowler = new LinkedList<>();
        for(Team team:teamLinkedList){
            if(team.getRole().equals("BOWLER")){
                topBowler.add(new Pair(team.getPlayer_name(),team.getWickets() ));
            }
        }
        Collections.sort(topBowler,new ClassCompare());
        int index = 3;
        logger.info("Top Bowlers: ");
        for(Pair pair:topBowler){
            if(index == 0) break;
            logger.info(pair.getName());
            index--;
        }

        logger.info("");
        LinkedList<Pair> topBatsman = new LinkedList<>();
        for(Team team:teamLinkedList){
            if(team.getRole().equals("BATSMAN")){
                topBowler.add(new Pair(team.getPlayer_name(),team.getWickets() ));
            }
        }
        Collections.sort(topBatsman,new ClassCompare());
        index = 3;
        logger.info("Top Batsman: ");
        for(Pair pair:topBatsman){
            if(index == 0) break;
            logger.info(pair.getName());
            index--;
        }

        logger.info("");
    }
    public Set<String> team(){
        Set<String> teamSet = new HashSet<>();
        for(Team team: teamLinkedList){
            teamSet.add(team.getTeam_name());
        }
        return teamSet;
    }
    public List<String[]> fixtures(){
        Set<String> teamSet = team();
        List<String[]> fixtures = new LinkedList<String[]>();
        LinkedList<String> listTeam = new LinkedList<>();
        for(String team:teamSet)listTeam.add(team);

        DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        int matchNumber = 1;
        for(int index=0 ; index < listTeam.size(); index++){
            for(int nextIndex = index+1; nextIndex < listTeam.size(); nextIndex++){
                String[] match = new String[5];
                match[0] = dF.format(c.getTime()).concat("\n 6:30 pm");
                match[1] = String.valueOf(matchNumber);
                matchNumber++;
                match[2] = listTeam.get(index);
                match[3] = listTeam.get(nextIndex);
                match[4] = listTeam.get(index).concat("_HOME");

                fixtures.add(match);
                String[] match2 = new  String[5];
                match2[0] = dF.format(c.getTime()).concat("\n 9:30 pm");
                match2[1] = String.valueOf(matchNumber);
                matchNumber++;
                match2[2] = listTeam.get(index);
                match2[3] = listTeam.get(nextIndex);
                match2[4] = listTeam.get(index).concat("_HOME");

                fixtures.add(match2);
                c.add(Calendar.DATE, 1);
            }
        }
        return fixtures;
    }
}
