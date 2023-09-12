package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;
import main_classes.Plant;

public class Goat extends Herbivorous {
    public Goat() {
        setName("goat");
        setIconUnicode("\uD83D\uDC10");
        setMaxNumberAnimalsInCell(140);
        setSpeedCellsMovement(3);
        setWeight(60);
        setKilogramsFoodForFullSaturation(10);
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

    protected Goat reproduction(Goat bear) {
        Goat bornAnimal = new Goat();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
