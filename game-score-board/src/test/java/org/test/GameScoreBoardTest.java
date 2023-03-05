package org.test;

import org.junit.jupiter.api.Test;
import org.test.board.GameScoreBoard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class GameScoreBoardTest {

    @Test
    void createNewGameOnScoreBoardWithInitialScore() {
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
}
