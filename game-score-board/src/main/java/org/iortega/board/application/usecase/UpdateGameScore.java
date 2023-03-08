package org.iortega.board.application.usecase;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.port.GameRepository;
import org.iortega.board.application.domain.exception.GameException;

public class UpdateGameScore {

    private GameRepository GameRepository;

    public UpdateGameScore(GameRepository GameRepository) {
        this.GameRepository = GameRepository;
    }

    public void exec(int homeTeamScore, int awayTeamScore, Game game) throws GameException {
        this.GameRepository.updateGameScore(homeTeamScore, awayTeamScore, game);
    }

}
