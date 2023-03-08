package org.iortega.board.application.usecase;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.port.GameRepository;

public class CreateGame {

    private GameRepository GameRepository;

    public CreateGame(GameRepository GameRepository) {
        this.GameRepository = GameRepository;
    }

    public Game exec(String homeTeamName, String awayTeamName, int gameIndex) {
        Game newGame = new Game(homeTeamName, awayTeamName, gameIndex);
        this.GameRepository.add(newGame);
        return newGame;
    }
}
