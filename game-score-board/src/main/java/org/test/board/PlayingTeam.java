package org.test.board;

public class PlayingTeam {

    private static final String SUMMARY_SEPARATOR = " ";
    private String name;
    private int score;

    protected PlayingTeam(String name){
        this.name = name;
        this.score = 0;
    }

    public String getTeamSummary() {
        return this.name.concat(SUMMARY_SEPARATOR).concat(this.getStringScore());
    }

    private String getStringScore() {
        return Integer.toString(this.score);
    }
}
