package ru.depi.game.sweeper;

/**
 * @author DePi
 **/

public class Coord {

    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coord) {
            Coord to = (Coord) o;
            return to.getX() == x && to.getY() == y;
        }
        return super.equals(o);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
