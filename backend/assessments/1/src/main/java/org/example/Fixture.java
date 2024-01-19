package org.example;
class Fixture {
    private String date;
    private Team homeTeam;
    private Team awayTeam;

    public Fixture(String date, Team homeTeam, Team awayTeam) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String toCSVString(int matchNumber) {
        return String.format("%s,%d,%s,%s,%s", date, matchNumber, homeTeam.getName(),
                awayTeam.getName(), homeTeam.getName() + "_home");
    }
}
