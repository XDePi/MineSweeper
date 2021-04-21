package ru.depi.game.sweeper;

import ru.depi.game.sweeper.enums.Box;

/**
 * @author DePi
 **/

class Matrix {
    private Box[][] matrix;

    Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().getX()][Ranges.getSize().getY()];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix [coord.getX()][coord.getY()] = defaultBox;
        }
    }

    Box get(Coord coord) {
        if (Ranges.inRange(coord))
            return matrix[coord.getX()][coord.getY()];
        return null;
    }

    void set(Coord coord, Box box) {
        matrix[coord.getX()][coord.getY()] = box;
    }
}
