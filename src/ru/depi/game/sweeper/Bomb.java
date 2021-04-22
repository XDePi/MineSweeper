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
        placeBomb();
    }

    private void placeBomb() {
        bombMap.set(new Coord(4, 4), Box.BOMB);
    }

    Box get(Coord coord) {
        return  bombMap.get(coord);
    }
}
