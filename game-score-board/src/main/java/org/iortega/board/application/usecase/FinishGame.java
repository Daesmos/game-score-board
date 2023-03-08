package org.iortega.board.application.usecase;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.port.GameRepository;
import org.iortega.board.application.domain.exception.GameException;

public class FinishGame {

    private GameRepository GameRepository;

    public FinishGame(GameRepository GameRepository) {
        this.GameRepository = GameRepository;
    }

    public boolean exec(Game game) throws GameException {
        return GameRepository.remove(game);
    }
}
