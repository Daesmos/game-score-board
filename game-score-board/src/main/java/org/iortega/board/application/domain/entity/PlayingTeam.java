package org.iortega.board.application.domain.entity;

public class PlayingTeam {

    private static final String SUMMARY_SEPARATOR = " ";
    private String name;
    private int score;

    public PlayingTeam(String name){
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeamSummary() {
        return this.name.concat(SUMMARY_SEPARATOR).concat(this.getStringScore());
    }

    private String getStringScore() {
        return Integer.toString(this.score);
    }
}
