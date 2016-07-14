package io.github.expansionteam.battleships.engine.board;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static org.testng.Assert.assertEquals;

public class BoardTest {

    @Test
    public void iteratesOverAllFields() {
        // given
        Map<Position, Field> fields = new TreeMap<>();
        fields.put(Position.of("1"), new Field(false));
        fields.put(Position.of("2"), new Field(true));
        fields.put(Position.of("3"), new Field(false));
        Board board = new Board(fields);
        Iterator<Field> expectedIterator = fields.values().iterator();

        // when
        Iterator<Field> computedIterator = board.iterator();

        // then
        assertEquals(computedIterator.next().isOccupied(), false);
        assertEquals(computedIterator.next().isOccupied(), true);
        assertEquals(computedIterator.next().isOccupied(), false);
    }
}
