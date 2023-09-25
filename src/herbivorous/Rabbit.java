package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;

public class Rabbit extends Herbivorous {
    public Rabbit() {
        setName("rabbit");
        setIconUnicode("\uD83D\uDC07");
        setMaxNumberAnimalsInCell(150);
        setSpeedCellsMovement(2);
        setWeight(2);
        setKilogramsFoodForFullSaturation(0.45);
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

    protected Rabbit reproduction(Rabbit rabbit) {
        Rabbit bornAnimal = new Rabbit();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
