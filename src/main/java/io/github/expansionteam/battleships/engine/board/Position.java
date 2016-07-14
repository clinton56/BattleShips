package io.github.expansionteam.battleships.engine.board;

public class Position implements Comparable<Position> {

    private final String value;

    static Position of(String value) {
        return new Position(value);
    }

    private Position(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Position position) {
        return value.compareTo(position.getValue());
    }
}
