package ru.depi.game.sweeper;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author DePi
 **/

public class Ranges {

    private static Coord size;
    private static ArrayList<Coord> allCoords;
    private static Random random = new Random();

    public static void setSize(Coord size) {
        Ranges.size = size;
        allCoords = new ArrayList<Coord>();
        for (int y = 0; y < size.getY(); y++) {
            for (int x = 0; x < size.getX(); x++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    public static void setAllCoords(ArrayList<Coord> allCoords) {
        Ranges.allCoords = allCoords;
    }

    static boolean inRange(Coord coord) {
        return coord.getX() >= 0 && coord.getX() < size.getX()
                && coord.getY() >= 0 && coord.getY() < size.getY();
    }

    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.getX()), random.nextInt(size.getY()));
    }
}
