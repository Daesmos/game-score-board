package org.test.board;

import java.util.List;

public class GameScoreBoard {

    private PlayingTeam homeTeam;
    private PlayingTeam awayTeam;

    public void createGame(String homeTeamName, String awayTeamName) {
        this.homeTeam = new PlayingTeam(homeTeamName);
        this.awayTeam = new PlayingTeam(awayTeamName);
    }

    public List<String> getSummary() {
        return List.of(this.homeTeam.getTeamSummary().concat(" - ").concat(this.awayTeam.getTeamSummary()));
    }
}
