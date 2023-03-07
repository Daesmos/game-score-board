package org.test.board;

import org.test.board.domain.BasicGameScoreBoard;
import org.test.board.domain.Game;
import org.test.board.domain.IGameScoreBoard;
import org.test.board.exception.GameNotFoundException;

import java.util.List;

public class GameScoreBoard {

    IGameScoreBoard board = new BasicGameScoreBoard();

    /**
     * Start a game on the board with score 0 - 0
     *
     * @param homeTeamName Home's Team name
     * @param awayTeamName Away's Team name
     * @return the game created
     */
    public Game createGame(String homeTeamName, String awayTeamName) {
        return this.board.createGame(homeTeamName, awayTeamName);
    }

    /**
     * Get a summary of games by total score.
     * Those games with the same total score will be returned ordered by the most recently added to the board.
     *
     * @return the summary result
     */
    public List<String> getSummary() {
        return this.board.getSummary();
    }

    /**
     * Remove a given Game from the board
     *
     * @param game Game to be removed
     * @return True if the game has been successfully removed
     * @throws GameNotFoundException in case the game does not exist on the board
     */
    public boolean finishGame(Game game) throws GameNotFoundException {
        return this.board.finishGame(game);
    }

    /**
     * Updates the score of a given Game
     *
     * @param homeTeamScore The new Home's Team Score
     * @param awayTeamScore The new Away's Team Score
     * @param game Game to be updated
     * @throws GameNotFoundException in case the game does not exist on the board
     */
    public void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException {
        this.board.updateGameScore(homeTeamScore, awayTeamScore, game);
    }
}
