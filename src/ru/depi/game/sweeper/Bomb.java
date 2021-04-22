package ru.depi.game.sweeper;

import ru.depi.game.sweeper.enums.Box;

/**
 * @author DePi
 **/

class Bomb {

    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    private void placeBomb() {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord, Box.BOMB);
        incrementNumbersAroundBomb(coord);
    }
    private void incrementNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord)) {
            if (Box.BOMB != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
        }
    }


    Box get(Coord coord) {
        return  bombMap.get(coord);
    }
}
