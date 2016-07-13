package io.github.expansionteam.battleships.engine.board;

class Field {

    private boolean occupied;

    Field(boolean occupied) {
        this.occupied = occupied;
    }

    boolean isOccupied() {
        return occupied;
    }
}
