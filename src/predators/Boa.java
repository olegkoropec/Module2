package predators;

import herbivorous.*;
import main_classes.Animal;
import main_classes.Cell;
import main_classes.Predator;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Boa extends Predator {
    Map<Class<? extends Animal>, Integer> animalMayBeEaten = Map.of(Rabbit.class, 20, Mouse.class, 40,
            Duck.class, 10, Fox.class, 15);

    public Boa() {
        setName("boa");
        setIconUnicode("\uD83D\uDC0D");
        setMaxNumberAnimalsInCell(30);
        setSpeedCellsMovement(1);
        setWeight(15);
        setKilogramsFoodForFullSaturation(3);
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

    protected Boa reproduction(Boa bear) {
        Boa bornAnimal = new Boa();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
