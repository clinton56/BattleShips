package io.github.expansionteam.battleships.engine.board;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class BoardTest {

    @Test
    public void returnsFieldIterator() {

        // given
        Map<Position, Field> fields = new HashMap<>();
        fields.put(Position.of("1"), new Field(true));
        fields.put(Position.of("2"), new Field(true));
        fields.put(Position.of("3"), new Field(true));
        Board board = new Board(fields);

        Iterator<Field> expectedIterator = fields.values().iterator();

        // when
        Iterator<Field> computedIterator = board.iterator();

        // then
        assertEquals(computedIterator, expectedIterator);
    }
}
