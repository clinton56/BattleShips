package io.github.expansionteam.battleships.engine.board;

public class Field {

    private boolean occupied;

    Field(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
