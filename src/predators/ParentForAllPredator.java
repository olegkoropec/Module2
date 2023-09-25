package predators;

import all_creatures.Animal;
import draw_field.Cell;

import java.util.concurrent.ThreadLocalRandom;

public class ParentForAllPredator extends Animal {
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
            Integer coordinatesXOrY = random.nextInt(2);
            boolean coordinateX = coordinatesXOrY.equals(0);
            boolean coordinateY = coordinatesXOrY.equals(1);
            Integer plusOrMinus = random.nextInt(2);
            boolean plus = plusOrMinus.equals(0);
            boolean minus = plusOrMinus.equals(1);
            if (coordinateX && plus)
                x ++;
            else if (coordinateX && minus && x > 0)
                x --;
            else if (coordinateY && plus)
                y ++;
            else if (coordinateY && minus && y > 0)
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
