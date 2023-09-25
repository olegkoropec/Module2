package predators;

import main_classes.Predator;
import herbivorous.*;
import main_classes.Animal;
import main_classes.Cell;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Eagle extends Predator {
    Map<Class<? extends Animal>, Integer> animalMayBeEaten = Map.of(Rabbit.class, 90, Mouse.class, 90,
            Duck.class, 80, Fox.class, 10);

    public Eagle() {
        setName("eagle");
        setIconUnicode("\uD83E\uDD85");
        setMaxNumberAnimalsInCell(20);
        setSpeedCellsMovement(3);
        setWeight(6);
        setKilogramsFoodForFullSaturation(1);
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

    protected Eagle reproduction(Eagle eagle) {
        Eagle bornAnimal = new Eagle();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
