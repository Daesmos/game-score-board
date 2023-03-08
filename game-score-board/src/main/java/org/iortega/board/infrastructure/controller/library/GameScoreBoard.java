package org.iortega.board.infrastructure.controller.library;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.exception.GameException;
import org.iortega.board.application.domain.port.GameRepository;
import org.iortega.board.application.usecase.CreateGame;
import org.iortega.board.application.usecase.FinishGame;
import org.iortega.board.application.usecase.GetGamesSummary;
import org.iortega.board.application.usecase.UpdateGameScore;
import org.iortega.board.infrastructure.adapter.repository.InMemoryListGameRepository;

import java.util.List;

public class GameScoreBoard {

    private int gamesAddedIndex;
    private GameRepository gamesRepository;

    private CreateGame createGameUseCase;
    private FinishGame finishGameUseCase;
    private UpdateGameScore updateGameScoreGameUseCase;
    private GetGamesSummary getGamesSummaryUseCase;

    public GameScoreBoard() {
        this.gamesAddedIndex = 0;
        this.gamesRepository = new InMemoryListGameRepository();
        this.createGameUseCase = new CreateGame(this.gamesRepository);
        this.finishGameUseCase = new FinishGame(this.gamesRepository);
        this.updateGameScoreGameUseCase = new UpdateGameScore(this.gamesRepository);
        this.getGamesSummaryUseCase = new GetGamesSummary(this.gamesRepository);
    }

    /**
     * Start a game on the board with score 0 - 0
     *
     * @param homeTeamName Home's Team name
     * @param awayTeamName Away's Team name
     * @return the game created
     */
    public Game createGame(String homeTeamName, String awayTeamName) {
        this.gamesAddedIndex++;
        return this.createGameUseCase.exec(homeTeamName, awayTeamName, this.gamesAddedIndex);
    }

    /**
     * Updates the score of a given Game
     *
     * @param homeTeamScore The new Home's Team Score
     * @param awayTeamScore The new Away's Team Score
     * @param game Game to be updated
     * @throws GameException in case the game does not exist on the board
     */
    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameException {
        this.updateGameScoreGameUseCase.exec(homeTeamScore, awayTeamScore, game);
    }

    /**
     * Remove a given Game from the board
     *
     * @param game Game to be removed
     * @return True if the game has been successfully removed
     * @throws GameException in case the game does not exist on the board
     */
    public boolean finishGame(Game game) throws GameException {
        return this.finishGameUseCase.exec(game);
    }

    /**
     * Get a summary of games by total score.
     * Those games with the same total score will be returned ordered by the most recently added to the board.
     *
     * @return the summary result
     */
    public List<String> getSummary() {
        return this.getGamesSummaryUseCase.exec();
    }
}
