package io.github.expansionteam.battleships.engine.board;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PositionTest {

    @Test
    public void createsPosition() {

        // given
        Position position = Position.of("test");

        // when
        String expectedValue = position.getValue();

        // then
        assertEquals(expectedValue, "test");
    }
}