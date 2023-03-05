package org.test.board;

public class Game {

    private static final String SUMMARY_SEPARATOR = " - ";
    private PlayingTeam homeTeam;
    private PlayingTeam awayTeam;

    protected Game(String homeTeamName, String awayTeamName) {
        this.homeTeam = new PlayingTeam(homeTeamName);
        this.awayTeam = new PlayingTeam(awayTeamName);

    }

    public String getGameSummary() {
        return this.homeTeam.getTeamSummary().concat(SUMMARY_SEPARATOR).concat(this.awayTeam.getTeamSummary());
    }
}
