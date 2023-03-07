package org.test.board.domain;

import org.test.board.exception.GameNotFoundException;
import org.test.board.repository.InMemoryListScoreBoardRepository;
import org.test.board.repository.ScoreBoardRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicGameScoreBoard implements IGameScoreBoard {

    int gamesAddedIndex;
    ScoreBoardRepository gamesRepository;

    public BasicGameScoreBoard() {
        this.gamesAddedIndex = 0;
        this.gamesRepository = new InMemoryListScoreBoardRepository();
    }

    public Game createGame(String homeTeamName, String awayTeamName) {
        this.gamesAddedIndex++;
        Game newGame = new Game(homeTeamName, awayTeamName, this.gamesAddedIndex);
        gamesRepository.add(newGame);
        return newGame;
    }

    public List<String> getSummary() {
        return gamesRepository.getAllGames().stream()
                .sorted(Comparator
                        .comparingInt(Game::getSumScore)
                        .thenComparing(Game::getIndex)
                        .reversed())
                .map(Game::getGameSummary)
                .collect(Collectors.toList());
    }

    public boolean finishGame(Game game) throws GameNotFoundException {
        return gamesRepository.remove(game);
    }

    public void updateGameScore (int homeTeamScore, int awayTeamScore, Game game) throws GameNotFoundException {
        this.gamesRepository.updateGameScore(homeTeamScore, awayTeamScore, game);
    }
}
