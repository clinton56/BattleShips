package io.github.expansionteam.battleships.engine.board;

public interface IBoardBuilder {

    IBoardBuilder addFields();

    Board build();
}
