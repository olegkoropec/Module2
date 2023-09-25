package herbivorous;

import model.field.Cell;
import model.creatures.Organisms;
import model.creatures.Plant;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends VegetarianAncestor {
    Map<Class<? extends Organisms>, Integer> mayBeEaten = Map.of(Caterpillar.class, 90, Plant.class, 100);

    public Mouse() {
        setName("mouse");
        setIconUnicode("\uD83D\uDC01");
        setMaxNumberAnimalsInCell(500);
        setSpeedCellsMovement(1);
        setWeight(0.05);
        setKilogramsFoodForFullSaturation(0.01);
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

    protected Mouse reproduction(Mouse mouse) {
        Mouse bornAnimal = new Mouse();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
