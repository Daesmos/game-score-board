# game-score-board
Implementation of the Football World Cup Score Board as a library

It allows you to create a Score Board where you can add games, update your score, get a summary of the games on the board and finish games.

The summary is ordered by total score. Those games with the same total score will be returned ordered by the most recently added to the board.

### Assumptions

- The user can only interact with the GameScoreBoard class, BasicGameScoreBoard class and IGameScoreBoard interface.
- The user does not have to interact with any of the other inner classes.
- The board can have more than one game.
- To indicate to the board that a game is over, the user must indicate which game it is.
- To update the scoreboard for a game, the user must indicate not only the new markers, but also the game to which they apply.
- The user can create several boards at the same time.
- If the user tries to end or modify a game that does not belong to a board, an exception will be returned.