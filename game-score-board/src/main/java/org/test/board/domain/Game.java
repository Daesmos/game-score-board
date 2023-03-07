package org.test.board.domain;

public class Game {

    private static final String SUMMARY_SEPARATOR = " - ";

    int index;
    private PlayingTeam homeTeam;
    private PlayingTeam awayTeam;

    protected Game(String homeTeamName, String awayTeamName, int index) {
        this.index = index;
        this.homeTeam = new PlayingTeam(homeTeamName);
        this.awayTeam = new PlayingTeam(awayTeamName);
    }

    protected int getIndex() {
        return index;
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
