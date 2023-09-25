package herbivorous;

import all_creatures.Organisms;

public class Plant extends Organisms {
    public Plant() {
        setName("plant");
        setIconUnicode("\uD83C\uDF3F");
        setMaxNumberAnimalsInCell(200);
        setWeight(1);
        setAlive(true);
    }
}
