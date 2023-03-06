package org.test.board;

import java.util.List;

public interface IGameScoreBoard {

    Game createGame(String homeTeamName, String awayTeamName);

    List<String> getSummary();

    boolean finishGame(Game game);
}
