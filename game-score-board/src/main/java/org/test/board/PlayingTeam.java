package org.test.board;

public class PlayingTeam {

    private String name;
    private int score;

    protected PlayingTeam(String name){
        this.name = name;
        this.score = 0;
    }

    public String getTeamSummary() {
        return this.name.concat(" ").concat(this.getStringScore());
    }

    private String getStringScore() {
        return Integer.toString(this.score);
    }
}
