package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;
import main_classes.Plant;

public class Caterpillar extends Herbivorous {
    public Caterpillar() {
        setName("caterpillar");
        setIconUnicode("\uD83D\uDC1B");
        setMaxNumberAnimalsInCell(1000);
        setSpeedCellsMovement(0);
        setWeight(0.01);
        setKilogramsFoodForFullSaturation(0);
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

    protected Caterpillar reproduction(Caterpillar bear) {
        Caterpillar bornAnimal = new Caterpillar();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
