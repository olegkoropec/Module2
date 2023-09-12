package main_classes;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {
    private Cell cell;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    protected void move(int move) {
        int x = this.cell.getX();
        int y = this.cell.getY();
        for (int i = 0; i < move; i++) {
            int coordinatesXOrY = random.nextInt(2);
            int plusOrMinus = random.nextInt(2);
            if (coordinatesXOrY == 0 && plusOrMinus == 0)
                x ++;
            else if (coordinatesXOrY == 0 && plusOrMinus == 1 && x > 0)
                x --;
            else if (coordinatesXOrY == 1 && plusOrMinus == 0)
                y ++;
            else if (coordinatesXOrY == 1 && plusOrMinus == 1 && y > 0)
                y --;
        }
        this.cell.setX(x);
        this.cell.setY(y);
        System.out.print(this.getCell() + "; ");

        if ((getKilogramFoodInStomach() - getKilogramsFoodForFullSaturation()/20) > 0){
            setKilogramFoodInStomach(getKilogramFoodInStomach() - getKilogramsFoodForFullSaturation()/20);
            System.out.print(getKilogramFoodInStomach() + " - ");
        }
        else setAlive(false);
    }
}
