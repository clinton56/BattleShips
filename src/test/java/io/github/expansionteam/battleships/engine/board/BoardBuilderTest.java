package io.github.expansionteam.battleships.engine.board;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class BoardBuilderTest {

    @Test

    public void builBoardFromBoardSize() {
        // given
        BoardSize boardSizeMock = mock(BoardSize.class);
        when(boardSizeMock.getSize()).thenReturn(3);

        BoardBuilder boardBuilder = new BoardBuilder(boardSizeMock);

        // when
        boardBuilder.addFields();
        Board board = boardBuilder.build();
        // then
        int numberOfNotOccupiedFields = 0;
        for (Field field : board) {
            if (!field.isOccupied()) {
                numberOfNotOccupiedFields++;
            }
        }

        assertEquals(9, numberOfNotOccupiedFields);
    }
}