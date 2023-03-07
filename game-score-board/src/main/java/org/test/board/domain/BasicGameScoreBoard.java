package org.test.board.domain;

import org.test.board.exception.GameNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicGameScoreBoard implements IGameScoreBoard {

    int gamesAddedIndex;
    List<Game> games;

    public BasicGameScoreBoard() {
        this.gamesAddedIndex = 0;
        this.games = new ArrayList<>();
    }

    public Game createGame(String homeTeamName, String awayTeamName) {
        this.gamesAddedIndex++;
        Game newGame = new Game(homeTeamName, awayTeamName, this.gamesAddedIndex);
        games.add(newGame);
        return newGame;
    }

    public List<String> getSummary() {
        return games.stream()
                .sorted(Comparator
                        .comparingInt(Game::getSumScore)
                        .thenComparing(Game::getIndex)
                        .reversed())
                .map(Game::getGameSummary)
                .collect(Collectors.toList());
    }

    public boolean finishGame(Game game) throws GameNotFoundException {
        if(games.contains(game)) {
            return games.remove(game);
        } else {
            throw new GameNotFoundException();
        }
    }

    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException {
        if(games.contains(game)) {
            game.getHomeTeam().setScore(homeTeamScore);
            game.getAwayTeam().setScore(awayTeamScore);
        } else {
            throw new GameNotFoundException();
        }
    }
}
