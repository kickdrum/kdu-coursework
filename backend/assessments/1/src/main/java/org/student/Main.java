package org.student;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String PATH = "src/main/resources/IPL_2021-data.csv";
    public static Map<String, List<Player>> teams;

    public static void main(String[] args) throws IOException {
        Map<String, List<Player>> teams = CSVProcessor.readCSV(PATH);

        Scanner sc = new Scanner(System.in);
        boolean go = true;
        while(go){
            Logging.logInfo("Enter a option : \n1. Atleast 40 wickets \n2. Top Wicket Taker and Top Run Scorer \n3. Top 3 run scorer and wicket taker \n4. Exit");
            int opt = sc.nextInt();
            switch (opt){
                case 1 : {
                    Logging.logInfo("Enter team Name : ");
                    String teamName = sc.next();
                    Handler.fortyWickets(teamName,teams);
                    break;
                }
                case 2 : {
                    Logging.logInfo("Enter team Name : ");
                    String teamName = sc.next();
                    Handler.topOfTeam(teamName,teams);
                    break;
                }
                case 3 : {
                    Handler.top3Season(teams);
                    break;
                }
                default : {
                    go = false;
                    break;
                }
            }
        }

        List<String> teamsNames = new ArrayList<>();
        HashMap<String,String> stadiums = new HashMap<>();

        Logging.logInfo("Enter team Names : ");
        for(int i = 0; i < 8; i++){
            String name = sc.next();
            String stadium = name.concat(".stadium");
            teamsNames.add(name);
            stadiums.put(name,stadium);
        }

        List<String []> result = new ArrayList<>();
        HashSet<String> hmap = new HashSet<>();
        List<String []> finale = new ArrayList<>();

        int match = 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.set(2023,Calendar.JANUARY,16,18,30,0);

        for(String team : teamsNames){
            for(String opponent : teamsNames){

                String key = opponent.concat(team);
                String key1 = team.concat(opponent);
                if(team.equals(opponent) || hmap.contains(key) || hmap.contains(key1))    continue;

                String[] strArr = new String[5];
                String[] strArr1 = new String[5];

                strArr[0] = c.getTime().toString();
                c.add(Calendar.HOUR,3);
                strArr1[0] = c.getTime().toString();
                c.add(Calendar.HOUR,21);
                strArr[1] = Integer.toString(match);
                strArr1[1] = Integer.toString(match + 1);
                strArr[2] = team;
                strArr1[2] = opponent;
                strArr[3] = opponent;
                strArr1[3] = team;
                strArr[4] = stadiums.get(team);
                strArr1[4] = stadiums.get(opponent);

                hmap.add(key);
                hmap.add(key1);
                finale.add(strArr);
                finale.add(strArr1);

                match += 2;
            }
        }

        List<String[]> f = new ArrayList<>(finale);

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/matches.csv"))) {
            writer.writeAll(f);
        }




    }

}