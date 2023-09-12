package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;
import main_classes.Plant;

public class Deer extends Herbivorous {
    public Deer() {
        setName("deer");
        setIconUnicode("\uD83E\uDD8C");
        setMaxNumberAnimalsInCell(20);
        setSpeedCellsMovement(4);
        setWeight(300);
        setKilogramsFoodForFullSaturation(50);
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

    protected Deer reproduction(Deer bear) {
        Deer bornAnimal = new Deer();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
