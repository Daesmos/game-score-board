package org.test.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameScoreBoard {

    List<Game> games = new ArrayList<>();

    public void createGame(String homeTeamName, String awayTeamName) {
        Game newGame = new Game(homeTeamName, awayTeamName);
        games.add(newGame);
    }

    public List<String> getSummary() {
        return games.stream().map(Game::getGameSummary).collect(Collectors.toList());
    }

    public void finishGame() {
        games.remove(0);
    }
}
