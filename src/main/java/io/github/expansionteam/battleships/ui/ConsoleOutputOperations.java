package io.github.expansionteam.battleships.ui;

import io.github.expansionteam.battleships.engine.board.Board;

public class ConsoleOutputOperations implements OutputOperations {

    @Override
    public void drawBoard(Board board) {
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.showBoard(board);
    }

}
