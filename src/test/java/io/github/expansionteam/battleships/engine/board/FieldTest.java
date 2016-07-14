package io.github.expansionteam.battleships.engine.board;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FieldTest {

    @Test
    public void isOccupied() {
        // given
        Field field = new Field(true);

        // when & then
        assertTrue(field.isOccupied());
    }

    @Test
    public void isNotOccupied() {
        // given
        Field field = new Field(false);

        // when & then
        assertFalse(field.isOccupied());
    }
}