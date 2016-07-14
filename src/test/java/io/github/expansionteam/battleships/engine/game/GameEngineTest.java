package io.github.expansionteam.battleships.engine.game;

import io.github.expansionteam.battleships.engine.board.Board;
import io.github.expansionteam.battleships.engine.board.Field;
import io.github.expansionteam.battleships.ui.OutputOperations;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class GameEngineTest {

    @Test
    public void printEmptyBoard() {
        // given
        OutputOperations outputOperationsMock = mock(OutputOperations.class);
        GameEngine gameEngine = new GameEngine(outputOperationsMock);

        // when
        gameEngine.launch();

        // then
        ArgumentCaptor<Board> boardCaptor = ArgumentCaptor.forClass(Board.class);
        verify(outputOperationsMock).drawBoard(boardCaptor.capture());
        Board expectedBoard = boardCaptor.getValue();

        int numberOfOccupiedPositions = 0;
        for (Field field : expectedBoard) {
            if (field.isOccupied()) {
                numberOfOccupiedPositions++;
            }
        }
        assertEquals(numberOfOccupiedPositions, 0);
    }

}
