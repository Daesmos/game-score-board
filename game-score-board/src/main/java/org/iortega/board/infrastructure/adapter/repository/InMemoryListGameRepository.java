package org.iortega.board.infrastructure.adapter.repository;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.exception.GameException;
import org.iortega.board.application.domain.port.GameRepository;
import org.iortega.board.infrastructure.adapter.repository.exception.GameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryListGameRepository implements GameRepository {

    List<Game> games;

    public InMemoryListGameRepository() {
        this.games = new ArrayList<>();
    }

    public void add(Game newGame) {
        games.add(newGame);
    }

    public List<Game> getAllGames() {
        return this.games;
    }

    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameException {
        if(this.exist(game)) {
            game.getHomeTeam().setScore(homeTeamScore);
            game.getAwayTeam().setScore(awayTeamScore);
        } else {
            throw new GameNotFoundException();
        }
    }

    public boolean remove(Game game) throws GameException {
        if(games.contains(game)) {
            return games.remove(game);
        } else {
            throw new GameNotFoundException();
        }
    }

    public boolean exist(Game game) {
        return games.contains(game);
    }
}
