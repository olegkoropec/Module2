package herbivorous;

import model.field.Cell;
import model.creatures.Plant;

public class Caterpillar extends VegetarianAncestor {
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

    protected Caterpillar reproduction(Caterpillar caterpillar) {
        Caterpillar bornAnimal = new Caterpillar();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
