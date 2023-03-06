package org.test.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameScoreBoard {

    List<Game> games = new ArrayList<>();

    public Game createGame(String homeTeamName, String awayTeamName) {
        Game newGame = new Game(homeTeamName, awayTeamName);
        games.add(newGame);
        return newGame;
    }

    public List<String> getSummary() {
        return games.stream().map(Game::getGameSummary).collect(Collectors.toList());
    }

    public boolean finishGame(Game game) {
        return games.remove(game);
    }
}
