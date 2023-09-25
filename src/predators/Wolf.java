package predators;

import herbivorous.*;
import model.creatures.Animal;
import model.field.Cell;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends PredatorAncestor {
    Map<Class<? extends Animal>, Integer> animalMayBeEaten = Map.of(Rabbit.class, 60, Mouse.class, 80,
            Duck.class, 40, Horse.class, 10, Deer.class, 15, Goat.class, 60,
            Sheep.class, 70, Boar.class, 15, Buffalo.class, 10);

    public Wolf() {
        setName("wolf");
        setIconUnicode("🐺");
        setMaxNumberAnimalsInCell(30);
        setSpeedCellsMovement(3);
        setWeight(50);
        setKilogramsFoodForFullSaturation(8);
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

    protected Wolf reproduction(Wolf wolf) {
        Wolf bornAnimal = new Wolf();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
