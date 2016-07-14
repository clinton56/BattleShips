package io.github.expansionteam.battleships.engine.board;

import java.util.Map;
import java.util.TreeMap;

public class BoardBuilder implements IBoardBuilder {

    private Map<Position, Field> fields = new TreeMap<>();
    private int size;

    public BoardBuilder(BoardSize boardSize) {
        size = boardSize.getValue();
    }

    @Override
    public IBoardBuilder addFields() {
        for (char c = 'A'; c < 'A' + size; c++) {
            String nextPosition;
            for (int i = 1; i <= size; i++) {
                nextPosition = "" + c + i;
                fields.put(Position.of(nextPosition), new Field(false));
            }
        }
        return this;
    }

    @Override
    public Board build() {
        return new Board(fields);
    }

}
