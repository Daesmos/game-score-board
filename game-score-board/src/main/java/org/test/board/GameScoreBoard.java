package org.test.board;

import org.test.board.domain.BasicGameScoreBoard;
import org.test.board.domain.Game;
import org.test.board.domain.IGameScoreBoard;
import org.test.board.exception.GameNotFoundException;

import java.util.List;

public class GameScoreBoard {

    IGameScoreBoard board = new BasicGameScoreBoard();
    
    public Game createGame(String homeTeamName, String awayTeamName) {
        return this.board.createGame(homeTeamName, awayTeamName);
    }

    public List<String> getSummary() {
        return this.board.getSummary();
    }

    public boolean finishGame(Game game) throws GameNotFoundException {
        return this.board.finishGame(game);
    }

    public void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException {
        this.board.updateGameScore(homeTeamScore, awayTeamScore, game);
    }
}
