package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;

public class Sheep extends Herbivorous {

    public Sheep() {
        setName("sheep");
        setIconUnicode("\uD83D\uDC11");
        setMaxNumberAnimalsInCell(140);
        setSpeedCellsMovement(3);
        setWeight(70);
        setKilogramsFoodForFullSaturation(15);
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

    protected Sheep reproduction(Sheep sheep) {
        Sheep bornAnimal = new Sheep();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
