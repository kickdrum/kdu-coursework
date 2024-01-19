package org.example;

import com.opencsv.CSVWriter;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Main {

    static Execution execution =new Execution();
    public static LinkedList<String[]> parseCSV(String file){
        String line ;
        String splitBy =",";
        int i=0;
        LinkedList<String[]> linkedList= new LinkedList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] details = line.split(splitBy);
                if(i!=0)
                linkedList.add(details);

                i++;
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return linkedList;
    }
    public static void writeDataLineByLine(String filePath)
    {
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { "Date", "Match Number", "Team home", "Team away", "Ground" };
            writer.writeNext(header);

            List<String[]> fixtures = execution.fixtures();

            for(String[] timeTable: fixtures)
                 writer.writeNext(timeTable);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ParseException {
            LinkedList<String[]> teamList = parseCSV("src/main/resources/IPL_2021-data.csv");
        NumberFormat nf = NumberFormat.getInstance();
            for(String[] details :teamList) {

                Team team = new Team(details[0],details[1],details[2],Integer.parseInt(details[3]),Integer.parseInt(details[4]),nf.parse(details[5]).doubleValue(),nf.parse(details[6]).doubleValue(),Integer.parseInt(details[7]));
                 execution.teamLinkedList.add(team);
            }
         execution.print40Bowler("CSK");
         execution.printHighestPlayer("SRH");
         execution.topPerformer();

         writeDataLineByLine("src/main/resources/Fixtures.csv");
    }

}