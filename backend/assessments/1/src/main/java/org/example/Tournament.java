package org.example;

import java.util.Map;
import java.util.PriorityQueue;

import static org.example.Main.players;
import static org.example.Teams.teams;

public class Tournament {
    public static void atleast40Wicktes(){
        for(int i=0;i< players.size();i++){
            if(players.get(i).getWickets()>=40){
                System.out.println("Player: "+players.get(i).getName()+" Wicteks: "+players.get(i).getWickets());
            }
        }
    }

    public static void topPerformers(String team){
        if(teams.containsKey(team)){
            PriorityQueue<Map<Integer,String>> topScore = new PriorityQueue<>();
            PriorityQueue<Map<Integer,String>> topBowlers = new PriorityQueue<>();

//            for(int i=0;i<teams.size();i++){
//                if(teams.get(i).contains(team)){
//                    for(int j=0;j<teams.get(team).size();j++){
//                        for(int k=0;k<players.size();k++){
//                            if()
//                        }
//
//                    }
//                }
//            }
                for(int j=0;j<players.size();j++){
                    if(players.get(j).getTeam()==team){
                        topScore.add({players.get(j).getRuns(),players.get(j).getName()});
                    }

            }

        }
        else{
            System.out.println(team+" Team does not exsist");
        }

    }
}
