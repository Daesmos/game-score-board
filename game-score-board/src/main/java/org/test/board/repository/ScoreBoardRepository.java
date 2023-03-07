package org.test.board.repository;

import org.test.board.domain.Game;
import org.test.board.exception.GameNotFoundException;

import java.util.List;

public interface ScoreBoardRepository {

    public void add(Game newGame);
    public List<Game> getAllGames();
    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException;
    public boolean remove(Game game) throws GameNotFoundException;
    public boolean exist(Game game);

}
