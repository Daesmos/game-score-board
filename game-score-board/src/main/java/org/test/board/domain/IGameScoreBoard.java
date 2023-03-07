package org.test.board.domain;

import java.util.List;

public interface IGameScoreBoard {

    Game createGame(String homeTeamName, String awayTeamName);

    List<String> getSummary();

    boolean finishGame(Game game);

    void updateGameScore(int homeTeamScore, int awayTeamScore, Game game);
}
