package org.handson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.handson.logging.MyLogger;

import com.opencsv.CSVReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(new File("src/main/resources/IPL_2021-data.csv"));
        String fileName = "src/main/resources/IPL_2021-data.csv";
        Season season  = new Season();
        try(CSVReader reader = new CSVReader(new FileReader(fileName)))
        { reader.readNext();
            List<String[]> csvData = reader.readAll();
            for(String[] row:csvData)
            {
                String name = row[0];
                String team = row[1];
                String role = row[2];
                Integer matches = Integer.parseInt(row[3]);
                Integer runs = Integer.parseInt(row[4]);
                Double average =  Double.parseDouble(row[5]);
                Double sR = Double.parseDouble(row[6]);
                Integer wickets = Integer.parseInt(row[7]);
                MyLogger.customLogger(name+" team is "+team+" "+role+" "+matches+" "+runs+" "+average+" "+sR+" "+wickets , "INFO");
                Team teamObj = season.addTeam(team);
                teamObj.addPlayer(name,role,matches,runs,average,sR,wickets);
        
            }
        }
        

        MyLogger.customLogger("Enter 1 for all the bowlers who have taken at least 40\n" + //
                "wickets.", "DEBUG");
        MyLogger.customLogger("Enter 2 for Given a team display the details of the highest wicket-taker and highest\n" + //
                "run-scorer","DEBUG" );
        MyLogger.customLogger("Enter 3 for the details of the top 3 wicket takers of the season", "DEBUG");
        MyLogger.customLogger("Enter 4 for fixtures", "DEBUG");
        Scanner sc1 = new Scanner(System.in);
        int choice = Integer.parseInt(sc1.nextLine());
        switch(choice)
        {
            case 1 :
                MyLogger.customLogger("Enter the team name", "DEBUG");
                String teamName = sc1.nextLine();
                List<String> bowlers = season.getTeam(teamName).getBowlers();
                for(String bowler : bowlers)
                {
                    MyLogger.customLogger(bowler, "DEBUG");
                }
                break;
            
            case 2 : MyLogger.customLogger("Enter the team name", "DEBUG");
                     String teamName2 = sc1.nextLine(); 
                     MyLogger.customLogger(season.getTeam(teamName2).maximumWickets().toString(), "DEBUG");
                     MyLogger.customLogger(season.getTeam(teamName2).maximumRuns().toString(), "DEBUG");

                    break;
            case 3 :
                        ArrayList<Player> players = season.getTop3WithHighestWicketTaker();
                        for(Player player : players)
                        {
                            MyLogger.customLogger(player.toString(), "DEBUG");
                        }
                        players = season.getTeamWithHighestScoreRunner();
                        for(Player player : players)
                        {
                            MyLogger.customLogger(player.toString(), "DEBUG");
                        }

                    break;
            case 4: MyLogger.customLogger("Writing into the CSV File.. ", "INFO");
            season.createMatchFixtures();
            break;

            default: MyLogger.customLogger("Invalid choice", "ERROR");
        }


         
    }
}
