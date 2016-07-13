package io.github.expansionteam.battleships.engine.board;

import java.util.Iterator;
import java.util.Map;

public class Board {
    Map<Position, Field> map;

    public Board(Map<Position, Field> fields) {
        this.map = fields;
    }

    public Iterator<Field> iterator() {
        return map.values().iterator();
    }
}
