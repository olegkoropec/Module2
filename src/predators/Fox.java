package predators;

import herbivorous.*;
import main_classes.Animal;
import main_classes.Cell;
import main_classes.Predator;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Predator {
    Map<Class<? extends Animal>, Integer> animalMayBeEaten = Map.of(Rabbit.class, 70, Mouse.class, 90,
            Duck.class, 60, Caterpillar.class, 40);

    public Fox() {
        setName("fox");
        setIconUnicode("\uD83E\uDD8A");
        setMaxNumberAnimalsInCell(30);
        setSpeedCellsMovement(2);
        setWeight(8);
        setKilogramsFoodForFullSaturation(2);
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

    protected Fox reproduction(Fox bear) {
        Fox bornAnimal = new Fox();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
