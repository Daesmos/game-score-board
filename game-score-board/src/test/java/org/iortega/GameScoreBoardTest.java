package org.iortega;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.exception.GameException;
import org.iortega.board.infrastructure.adapter.repository.exception.GameNotFoundException;

import java.util.List;

import org.iortega.board.infrastructure.controller.library.GameScoreBoard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameScoreBoardTest {

    @Test
    void createGameOnScoreBoardWithInitialScore() {
        GameScoreBoard board = new GameScoreBoard();
        board.createGame("Mexico", "Canada");

        List<String> summary = board.getSummary();
        List<String> expectedSummary = List.of("Mexico 0 - Canada 0");

        assertLinesMatch(expectedSummary, summary);
    }

    @Test
    void createDifferentNewGameOnScoreBoardWithInitialScore() {
        GameScoreBoard board = new GameScoreBoard();
        board.createGame("Spain", "Brazil");

        List<String> summary = board.getSummary();
        List<String> expectedSummary = List.of("Spain 0 - Brazil 0");

        assertLinesMatch(expectedSummary, summary);
    }

    @Test
    void finishGame() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");

        boolean finishResult = board.finishGame(gameMexCan);
        assertTrue(finishResult);
        assertLinesMatch(List.of(), board.getSummary());
    }

    @Test
    void createTwoGamesAndFinishOnlyOne() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        board.createGame("Spain", "Brazil");

        boolean finishResult = board.finishGame(gameMexCan);

        List<String> expectedSummary = List.of("Spain 0 - Brazil 0");

        assertTrue(finishResult);
        assertLinesMatch(expectedSummary, board.getSummary());
    }

    @Test
    void updateGameScore() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        board.updateGameScore(2, 1, gameMexCan);

        List<String> expectedSummary = List.of("Mexico 2 - Canada 1");
        assertLinesMatch(expectedSummary, board.getSummary());
    }

    @Test
    void updateGameScoreSeveralTimes() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        board.updateGameScore(0, 1, gameMexCan);
        board.updateGameScore(0, 2, gameMexCan);
        board.updateGameScore(0, 3, gameMexCan);
        board.updateGameScore(1, 3, gameMexCan);
        board.updateGameScore(1, 4, gameMexCan);

        List<String> expectedSummary = List.of("Mexico 1 - Canada 4");
        assertLinesMatch(expectedSummary, board.getSummary());
    }

    @Test
    void throwExceptionWhenTryingFinishGameOfAnotherBoard() {
        GameScoreBoard spanishGamesBoard = new GameScoreBoard();
        GameScoreBoard frenchGamesBoard = new GameScoreBoard();

        Game gameSevBet = spanishGamesBoard.createGame("Sevilla", "Betis");
        frenchGamesBoard.createGame("Monaco", "Marseille");

        assertThrows(GameNotFoundException.class, () -> frenchGamesBoard.finishGame(gameSevBet));
    }

    @Test
    void throwExceptionWhenTryingUpdateGameOfAnotherBoard() {
        GameScoreBoard spanishGamesBoard = new GameScoreBoard();
        GameScoreBoard frenchGamesBoard = new GameScoreBoard();

        Game gameSevBet = spanishGamesBoard.createGame("Sevilla", "Betis");
        frenchGamesBoard.createGame("Monaco", "Marseille");

        assertThrows(GameNotFoundException.class, () -> frenchGamesBoard.updateGameScore( 2, 1, gameSevBet));
    }

    @Test
    void getSummaryOrderByTotalGameScore() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        Game gameSpaBra = board.createGame("Spain", "Brazil");
        Game gameGerFra = board.createGame("Germany", "France");

        board.updateGameScore(1, 2, gameGerFra);
        board.updateGameScore(2, 3, gameMexCan);
        board.updateGameScore(4, 3, gameSpaBra);

        List<String> expectedSummary = List.of(
                "Spain 4 - Brazil 3",
                "Mexico 2 - Canada 3",
                "Germany 1 - France 2");
        assertLinesMatch(expectedSummary, board.getSummary());
    }

    @Test
    void getSummaryOrderWithSameTotalByMostRecentlyAdded() throws GameException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        Game gameSpaBra = board.createGame("Spain", "Brazil");
        Game gameGerFra = board.createGame("Germany", "France");
        Game gameUruIta = board.createGame("Uruguay", "Italy");
        Game gameArgAus = board.createGame("Argentina", "Australia");

        board.updateGameScore(2, 2, gameGerFra);
        board.updateGameScore(0, 5, gameMexCan);
        board.updateGameScore(10, 2, gameSpaBra);
        board.updateGameScore(6, 6, gameUruIta);
        board.updateGameScore(3, 1, gameArgAus);

        List<String> expectedSummary = List.of(
                "Uruguay 6 - Italy 6",
                "Spain 10 - Brazil 2",
                "Mexico 0 - Canada 5",
                "Argentina 3 - Australia 1",
                "Germany 2 - France 2");
        assertLinesMatch(expectedSummary, board.getSummary());
    }

}
