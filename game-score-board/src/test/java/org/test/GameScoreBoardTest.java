package org.test;

import org.junit.jupiter.api.Test;
import org.test.board.Game;
import org.test.board.GameScoreBoard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void finishGame() {
        GameScoreBoard board = new GameScoreBoard();
        Game gameA = board.createGame("Mexico", "Canada");

        boolean finishResult = board.finishGame(gameA);
        assertTrue(finishResult);
        assertLinesMatch(List.of(), board.getSummary());
    }

    @Test
    void createTwoGamesAndFinishOnlyOne() {
        GameScoreBoard board = new GameScoreBoard();
        Game gameA = board.createGame("Mexico", "Canada");
        Game gameB = board.createGame("Spain", "Brazil");

        boolean finishResult = board.finishGame(gameA);
        assertTrue(finishResult);
        assertLinesMatch(List.of(gameB.getGameSummary()), board.getSummary());
    }

}
