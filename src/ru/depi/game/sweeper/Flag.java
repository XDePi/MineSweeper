package ru.depi.game.sweeper;

import ru.depi.game.sweeper.enums.Box;

/**
 * @author DePi
 **/

class Flag {

    private Matrix flagMap;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
    }

    public void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
    }
}
