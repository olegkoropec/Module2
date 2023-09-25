package predators;

import main_classes.Predator;
import herbivorous.*;
import main_classes.Animal;
import main_classes.Cell;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {
    Map<Class<? extends Animal>, Integer> animalMayBeEaten = Map.of(Boa.class, 80, Boar.class, 50, Deer.class, 80,
            Rabbit.class, 80, Horse.class, 40, Mouse.class, 90, Goat.class, 70, Sheep.class, 70,
            Buffalo.class, 20, Duck.class, 10);

    public Bear() {
        setName("bear");
        setIconUnicode("\uD83D\uDC3B");
        setMaxNumberAnimalsInCell(5);
        setSpeedCellsMovement(2);
        setWeight(500);
        setKilogramsFoodForFullSaturation(80);
        setAlive(true);
        setStarveDeath(false);
        setKilogramFoodInStomach(getKilogramsFoodForFullSaturation());
        setCell(new Cell());
    }

    protected void eat(Animal animal) {
        Integer percentToEat = animalMayBeEaten.get(animal.getClass());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomNumber = random.nextInt(100);
        if (getKilogramFoodInStomach() < getKilogramsFoodForFullSaturation() && randomNumber <= percentToEat) {
            double mayBeFoodInStomach = Math.min((getKilogramFoodInStomach() + animal.getWeight()), getKilogramsFoodForFullSaturation());
            setKilogramFoodInStomach(mayBeFoodInStomach);
            System.out.println(getKilogramFoodInStomach());
        }
        animal.setAlive(false);
    }

    protected Bear reproduction(Bear bear) {
        Bear bornAnimal = new Bear();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
