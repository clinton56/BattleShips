package io.github.expansionteam.battleships.engine.board;

class Position {

    private final String value;

    static Position of(String value) {
        return new Position(value);
    }

    private Position(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
