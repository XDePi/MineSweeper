package ru.depi.game.sweeper;

import ru.depi.game.sweeper.enums.Box;

/**
 * @author DePi
 **/

class Flag {

    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().getX() * Ranges.getSize().getY();
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED : setClosedToBox(coord); break;
            case CLOSED : setFlaggedToBox(coord); break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }

    private void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
    }

    public int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }
}
