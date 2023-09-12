package main_classes;

import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private int x;
    private int y;
    private Cell[][] cell = new Cell[x][y];

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

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        Cell numberCell = new Cell();

        for (int i = 0; i < new Cell().getX(); i++) {
            for (int j = 0; j < new Cell().getY(); j++) {

            }
        }

        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        Cell cell3 = new Cell();

//        System.out.println(cell1.getX() + ", " + cell1.getY());
//        System.out.println(cell2.getX() + ", " + cell2.getY());
//        System.out.println(cell3.getX() + ", " + cell3.getY());

        System.out.println(cell1);
    }
}
