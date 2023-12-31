package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;

public class Buffalo extends Herbivorous {
    public Buffalo() {
        setName("buffalo");
        setIconUnicode("\uD83D\uDC03");
        setMaxNumberAnimalsInCell(10);
        setSpeedCellsMovement(3);
        setWeight(700);
        setKilogramsFoodForFullSaturation(100);
        setAlive(true);
        setStarveDeath(false);
        setKilogramFoodInStomach(getKilogramsFoodForFullSaturation());
        setCell(new Cell());
    }

    protected void eat(Plant plant) {
        if (getKilogramFoodInStomach() < getKilogramsFoodForFullSaturation()) {
            double weightPlantToStomach = plant.getWeight() + getKilogramFoodInStomach();
            setKilogramFoodInStomach(weightPlantToStomach);
        }
        plant.setAlive(false);
    }

    protected Buffalo reproduction(Buffalo buffalo) {
        Buffalo bornAnimal = new Buffalo();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
