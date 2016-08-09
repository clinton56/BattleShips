package io.github.expansionteam.battleships;

import io.github.expansionteam.battleships.engine.Board;
import io.github.expansionteam.battleships.engine.Field;
import io.github.expansionteam.battleships.engine.Ship;
import org.apache.log4j.Logger;

import java.util.Collection;

import static io.github.expansionteam.battleships.engine.Board.BoardBuilder;
import static io.github.expansionteam.battleships.engine.Board.RandomShipGenerator;

public class Game {

    private static final Logger log = Logger.getLogger(Game.class);

    private final Board firstPlayerBoard = new BoardBuilder().build();
    private final Board secondPlayerBoard = new BoardBuilder().build();
    private final RandomShipGenerator randomShipGenerator = new RandomShipGenerator();

    public Collection<Ship> getPlayerShips() {
        Board board = currentBoard();
        return board.getShips();
    }

    public void generateRandomShips() {
        Board board = currentBoard();
        synchronized (randomShipGenerator) {
            randomShipGenerator.generateRandomShips(board);
        }
    }

    public boolean shootOpponentField(int x, int y) {
        return opponentBoard().shootField(x, y);
    }

    public boolean isOpponentFieldHit(int x, int y) {
        return opponentBoard().isFieldHit(x, y);
    }

    public boolean isOpponentShipDestroyed(int x, int y) {
        return opponentBoard().isDestroyedShip(x, y);
    }

    public boolean isOpponentShipHit(int x, int y) {
        return isShipField(opponentBoard(), x, y);
    }

    public Collection<Field> getAdjacentToOpponentShip(int x, int y) {
        return opponentBoard().getAdjacentToShip(x, y);
    }

    public boolean isEnded() {
        return opponentBoard().areAllShipsDestroyed();
    }

    private Board currentBoard() {
        return firstPlayer() ? firstPlayerBoard : secondPlayerBoard;
    }

    private Board opponentBoard() {
        return firstPlayer() ? secondPlayerBoard : firstPlayerBoard;
    }

    private boolean firstPlayer() {
        return Thread.currentThread().getName().contains("Player_1");
    }

    private boolean isShipField(Board board, int x, int y) {
        return board.getFieldFromTheBoard(x, y).isShip();
    }

    public boolean generatingShipsFinished() {
        return firstPlayerBoard.placingShipsFinished() && secondPlayerBoard.placingShipsFinished();
    }


}