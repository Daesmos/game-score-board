package org.test.board.repository;

import org.test.board.domain.Game;
import org.test.board.exception.GameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryListScoreBoardRepository implements ScoreBoardRepository {

    List<Game> games;

    public InMemoryListScoreBoardRepository() {
        this.games = new ArrayList<>();
    }

    public void add(Game newGame) {
        games.add(newGame);
    }

    public List<Game> getAllGames() {
        return this.games;
    }

    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException {
        if(this.exist(game)) {
            game.getHomeTeam().setScore(homeTeamScore);
            game.getAwayTeam().setScore(awayTeamScore);
        } else {
            throw new GameNotFoundException();
        }
    }

    public boolean remove(Game game) throws GameNotFoundException {
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
