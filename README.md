# game-score-board
Implementation of the Football World Cup Score Board as a library

It allows you to create a Score Board where you can add games, update your score, get a summary of the games on the board and finish games.

The summary is ordered by total score. Those games with the same total score will be returned ordered by the most recently added to the board.

## Operations availables

- **createGame:**<br>
	Start a game on the board with score 0 - 0

- **updateGameScore:**<br>
	Updates the score of a given Game

- **finishGame:**<br>
	Remove a given Game from the board

- **GetSummary:**<br>
	Get a summary of games by total score.
	Those games with the same total score will be returned ordered by the most recently added to the board.

### Assumptions

- The user should only interact with the GameScoreBoard class to do all operations.
- The board can have more than one game.
- To indicate to the board that a game is over, the user must indicate which game it is.
- To update the scoreboard for a game, the user must indicate not only the new markers, but also the game to which they apply.
- The user can create several boards at the same time.
- If the user tries to end or modify a game that does not belong to a board, an exception will be returned.