package herbivorous;

import model.field.Cell;
import model.creatures.Organisms;
import model.creatures.Plant;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Boar extends VegetarianAncestor {
    Map<Class<? extends Organisms>, Integer> mayBeEaten = Map.of(Mouse.class, 50, Caterpillar.class, 90, Plant.class, 100);

    public Boar() {
        setName("boar");
        setIconUnicode("\uD83D\uDC17");
        setMaxNumberAnimalsInCell(50);
        setSpeedCellsMovement(2);
        setWeight(400);
        setKilogramsFoodForFullSaturation(50);
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

    protected Boar reproduction(Boar boar) {
        Boar bornAnimal = new Boar();
        bornAnimal.setCell(this.getCell());
        return bornAnimal;
    }
}
