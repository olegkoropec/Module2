package herbivorous;

import model.field.Cell;
import model.creatures.Plant;

public class Horse extends VegetarianAncestor {
    public Horse() {
        setName("horse");
        setIconUnicode("\uD83D\uDC0E");
        setMaxNumberAnimalsInCell(20);
        setSpeedCellsMovement(4);
        setWeight(400);
        setKilogramsFoodForFullSaturation(60);
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

    protected Horse reproduction(Horse horse) {
        Horse bornAnimal = new Horse();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
