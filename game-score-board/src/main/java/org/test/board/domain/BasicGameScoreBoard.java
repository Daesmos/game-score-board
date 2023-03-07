package org.test.board.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicGameScoreBoard implements IGameScoreBoard {

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

    public void updateGameScore(int homeTeamScore, int awayTeamScore, Game game) {
        game.getHomeTeam().setScore(homeTeamScore);
        game.getAwayTeam().setScore(awayTeamScore);
    }
}
