package org.test.board;

import org.test.board.domain.BasicGameScoreBoard;
import org.test.board.domain.Game;
import org.test.board.domain.IGameScoreBoard;

import java.util.List;

public class GameScoreBoard {

    IGameScoreBoard gameScoreBoard = new BasicGameScoreBoard();

    public Game createGame(String homeTeamName, String awayTeamName) {
        return this.gameScoreBoard.createGame(homeTeamName, awayTeamName);
    }

    public List<String> getSummary() {
        return this.gameScoreBoard.getSummary();
    }

    public boolean finishGame(Game game) {
        return this.gameScoreBoard.finishGame(game);
    }

    public void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) {
        this.gameScoreBoard.updateGameScore(homeTeamScore, awayTeamScore, game);
    }
}
