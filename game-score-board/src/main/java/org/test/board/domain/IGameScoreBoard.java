package org.test.board.domain;

import org.test.board.exception.GameNotFoundException;

import java.util.List;

public interface IGameScoreBoard {

    /**
     * Start a game on the board with score 0 - 0
     *
     * @param homeTeamName Home's Team name
     * @param awayTeamName Away's Team name
     * @return the game created
     */
    Game createGame(String homeTeamName, String awayTeamName);

    /**
     * Get a summary of games by total score.
     * Those games with the same total score will be returned ordered by the most recently added to the board.
     *
     * @return the summary result
     */
    List<String> getSummary();

    /**
     * Remove a given Game from the board
     *
     * @param game Game to be removed
     * @return True if the game has been successfully removed
     * @throws GameNotFoundException in case the game does not exist on the board
     */
    boolean finishGame(Game game) throws GameNotFoundException;

    /**
     * Updates the score of a given Game
     *
     * @param homeTeamScore The new Home's Team Score
     * @param awayTeamScore The new Away's Team Score
     * @param game Game to be updated
     * @throws GameNotFoundException in case the game does not exist on the board
     */
    void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException;
}
