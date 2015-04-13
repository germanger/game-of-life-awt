# game-of-life-awt

This is a simple Java demonstration of **John Horton Conway's Game of Life** I did some years ago. I'm rescuing this old project from the now dead *code.google.com*

**From Wikipedia:**<br/>

>The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

>The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.

Basically, the game rules are these:

1. If a cell is live and has 2 or 3 living cell neighbors, it will continue living in the next round
2. If a cell is live and has 0 living neighbors, she will die next round
3. If a cell is live and has too many living neighbours (more than 3), she will die next round
4. If a cell is dead and has exactly 3 living neighbors, she will born the next round

![Board settings](/screenshots/board-settings-frame.jpg?raw=true "Board settings (splash frame)")

![The board itself](/screenshots/board-settings-frame.jpg?raw=true "The board itself")