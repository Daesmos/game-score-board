package org.iortega.board.application.domain.port;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.exception.GameException;

import java.util.List;

public interface GameRepository {

    void add(Game newGame);
    List<Game> getAllGames();
    void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameException;
    boolean remove(Game game) throws GameException;
    boolean exist(Game game);

}
