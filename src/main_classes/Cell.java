package main_classes;

import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private int x;
    private int y;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell() {
        setX(random.nextInt(20));
        setY(random.nextInt(100));
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
