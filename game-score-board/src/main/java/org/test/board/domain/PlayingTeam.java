package org.test.board.domain;

public class PlayingTeam {

    private static final String SUMMARY_SEPARATOR = " ";
    private String name;
    private int score;

    protected PlayingTeam(String name){
        this.name = name;
        this.score = 0;
    }

    protected void setScore(int score) {
        this.score = score;
    }

    protected String getTeamSummary() {
        return this.name.concat(SUMMARY_SEPARATOR).concat(this.getStringScore());
    }

    private String getStringScore() {
        return Integer.toString(this.score);
    }
}
