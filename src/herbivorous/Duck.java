package herbivorous;

import main_classes.Cell;
import main_classes.Herbivorous;
import main_classes.Organisms;
import main_classes.Plant;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivorous {
    Map<Class<? extends Organisms>, Integer> mayBeEaten = Map.of(Caterpillar.class, 90, Plant.class, 100);

    public Duck() {
        setName("duck");
        setIconUnicode("\uD83E\uDD86");
        setMaxNumberAnimalsInCell(200);
        setSpeedCellsMovement(4);
        setWeight(1);
        setKilogramsFoodForFullSaturation(0.15);
        setAlive(true);
        setStarveDeath(false);
        setKilogramFoodInStomach(getKilogramsFoodForFullSaturation());
        setCell(new Cell());
    }

    protected void eat(Organisms organisms) {
        Integer percentToEat = mayBeEaten.get(organisms.getClass());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomNumber = random.nextInt(100);
        if (getKilogramFoodInStomach() < getKilogramsFoodForFullSaturation() && randomNumber <= percentToEat) {
            double mayBeFoodInStomach = Math.min((getKilogramFoodInStomach() + organisms.getWeight()), getKilogramsFoodForFullSaturation());
            setKilogramFoodInStomach(mayBeFoodInStomach);
            System.out.println(getKilogramFoodInStomach());
        }
        organisms.setAlive(false);
    }

    protected Duck reproduction(Duck bear) {
        Duck bornAnimal = new Duck();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
