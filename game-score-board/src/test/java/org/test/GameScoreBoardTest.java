package org.test;

import org.junit.jupiter.api.Test;
import org.test.board.domain.Game;
import org.test.board.GameScoreBoard;
import org.test.board.exception.GameNotFoundException;

import java.util.List;

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
    void finishGame() throws GameNotFoundException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");

        boolean finishResult = board.finishGame(gameMexCan);
        assertTrue(finishResult);
        assertLinesMatch(List.of(), board.getSummary());
    }

    @Test
    void createTwoGamesAndFinishOnlyOne() throws GameNotFoundException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        board.createGame("Spain", "Brazil");

        boolean finishResult = board.finishGame(gameMexCan);

        List<String> expectedSummary = List.of("Spain 0 - Brazil 0");

        assertTrue(finishResult);
        assertLinesMatch(expectedSummary, board.getSummary());
    }

    @Test
    void updateGameScore() throws GameNotFoundException {
        GameScoreBoard board = new GameScoreBoard();
        Game gameMexCan = board.createGame("Mexico", "Canada");
        board.updateGameScore(2, 1, gameMexCan);

        List<String> expectedSummary = List.of("Mexico 2 - Canada 1");
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

}
