package org.test.board.domain;

public class Game {

    private static final String SUMMARY_SEPARATOR = " - ";
    private PlayingTeam homeTeam;
    private PlayingTeam awayTeam;

    protected Game(String homeTeamName, String awayTeamName) {
        this.homeTeam = new PlayingTeam(homeTeamName);
        this.awayTeam = new PlayingTeam(awayTeamName);
    }

    protected PlayingTeam getHomeTeam() {
        return homeTeam;
    }

    protected PlayingTeam getAwayTeam() {
        return awayTeam;
    }

    protected int getSumScore() {
        return this.homeTeam.getScore() + this.awayTeam.getScore();
    }

    protected String getGameSummary() {
        return this.homeTeam.getTeamSummary().concat(SUMMARY_SEPARATOR).concat(this.awayTeam.getTeamSummary());
    }
}
