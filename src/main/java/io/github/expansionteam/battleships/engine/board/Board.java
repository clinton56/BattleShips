package io.github.expansionteam.battleships.engine.board;

import java.util.Iterator;
import java.util.Map;

public class Board implements Iterable {
    private Map<Position, Field> map;

    Board(Map<Position, Field> fields) {
        this.map = fields;
    }

    @Override
    public Iterator<Field> iterator() {
        return new Iterator<Field>() {
            Iterator<Position> keyIterator = map.keySet().iterator();

            @Override
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            @Override
            public Field next() {
                return map.get(keyIterator.next());
            }
        };
    }
}
