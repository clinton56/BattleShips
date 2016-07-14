package io.github.expansionteam.battleships.engine.game;

import io.github.expansionteam.battleships.engine.board.Board;
import io.github.expansionteam.battleships.engine.board.BoardBuilder;
import io.github.expansionteam.battleships.engine.board.BoardSize;
import io.github.expansionteam.battleships.ui.OutputOperations;

public class GameEngine {

    private final OutputOperations outputOperations;

    public GameEngine(OutputOperations outputOperations) {
        this.outputOperations = outputOperations;
    }

    public void launch() {

        BoardBuilder boardBuilder = new BoardBuilder(new BoardSize(10));
        Board board = boardBuilder.addFields().build();
        outputOperations.drawBoard(board);

    }

}
