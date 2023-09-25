package all_creatures;

public class Organisms {
    private String name;
    private String iconUnicode;
    private int maxNumberAnimalsInCell;
    private double weight;
    private boolean isAlive;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIconUnicode() {
        return iconUnicode;
    }
    public void setIconUnicode(String iconUnicode) {
        this.iconUnicode = iconUnicode;
    }

    public int getMaxNumberAnimalsInCell() {
        return maxNumberAnimalsInCell;
    }
    public void setMaxNumberAnimalsInCell(int maxNumberAnimalsInCell) {
        this.maxNumberAnimalsInCell = maxNumberAnimalsInCell;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
