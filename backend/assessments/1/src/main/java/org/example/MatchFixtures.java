package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class MatchFixtures {

    public static void generateFixtures(List<Team> teams) {
        int totalTeams = teams.size();

        if (totalTeams % 2 != 0) {
            teams.add(new Team("Dummy"));
            totalTeams++;
        }

        int totalRounds = totalTeams - 1;
        int matchesPerRound = totalTeams / 2;

        List<String> dates = generateDates(totalRounds);
        List<Fixture> fixtures = new ArrayList<>();

        for (int round = 0; round < totalRounds; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                Team homeTeam = teams.get((round + match) % (totalTeams - 1));
                Team awayTeam = teams.get((totalTeams - 1 - match + round) % (totalTeams - 1));

                if (!homeTeam.getName().equals("Dummy") && !awayTeam.getName().equals("Dummy")) {
                    fixtures.add(new Fixture(dates.get(round), homeTeam, awayTeam));
                }
            }
        }

        writeFixturesToCSV(fixtures);
    }

    private static List<String> generateDates(int totalRounds) {
        List<String> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        for (int i = 0; i < totalRounds; i++) {
            calendar.add(Calendar.DATE, 1);
            dates.add(dateFormat.format(calendar.getTime()));
        }

        return dates;
    }

    private static void writeFixturesToCSV(List<Fixture> fixtures) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("fixtures.csv"))) {
            writer.println("Date,Match number,Team home,Team away,Ground");

            int matchNumber = 1;
            for (Fixture fixture : fixtures) {
                writer.println(fixture.toCSVString(matchNumber++));
            }

            System.out.println("Fixtures written to fixtures.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("MI"));
        teams.add(new Team("CSK"));

        generateFixtures(teams);
    }
}



