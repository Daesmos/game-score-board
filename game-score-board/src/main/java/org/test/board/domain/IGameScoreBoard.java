package org.test.board.domain;

import org.test.board.exception.GameNotFoundException;

import java.util.List;

public interface IGameScoreBoard {

    Game createGame(String homeTeamName, String awayTeamName);

    List<String> getSummary();

    boolean finishGame(Game game) throws GameNotFoundException;

    void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException;
}
