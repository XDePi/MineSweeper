package ru.depi.game.sweeper;

import ru.depi.game.sweeper.enums.Box;
import ru.depi.game.sweeper.enums.GameState;

/**
 * @author DePi
 **/

public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start() {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void pressLeftButton(Coord coord) {
        openBox(coord);
        checkWinner();
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case OPENED  : return;
            case FLAGGED : return;
            case CLOSED  :
                switch (bomb.get(coord)) {
                    case ZERO : openBoxesAround(coord); return;
                    case BOMB : return;
                    default   : flag.setOpenedToBox(coord); return;
                }
        }
    }

    private void checkWinner() {
        if (state== GameState.PLAYED)
            if (flag.getCountOfClosedBoxes() == bomb.getTotalBombs())
                state = GameState.WINNER;
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getCoordsAround(coord)) {
            openBox(around);
        }
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlaggedToBox(coord);
    }

    public GameState getState() {
        return state;
    }
}
