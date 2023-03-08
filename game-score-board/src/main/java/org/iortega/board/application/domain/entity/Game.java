package org.iortega.board.application.domain.entity;

public class Game {

    private static final String SUMMARY_SEPARATOR = " - ";

    int index;
    private PlayingTeam homeTeam;
    private PlayingTeam awayTeam;

    public Game(String homeTeamName, String awayTeamName, int index) {
        this.index = index;
        this.homeTeam = new PlayingTeam(homeTeamName);
        this.awayTeam = new PlayingTeam(awayTeamName);
    }

    public int getIndex() {
        return index;
    }

    public PlayingTeam getHomeTeam() {
        return homeTeam;
    }

    public PlayingTeam getAwayTeam() {
        return awayTeam;
    }

    public int getSumScore() {
        return this.homeTeam.getScore() + this.awayTeam.getScore();
    }

    public String getGameSummary() {
        return this.homeTeam.getTeamSummary().concat(SUMMARY_SEPARATOR).concat(this.awayTeam.getTeamSummary());
    }
}
