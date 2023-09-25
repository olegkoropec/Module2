package main_classes;

public class Animal extends Organisms {
    private int speedCellsMovement;
    private double kilogramsFoodForFullSaturation;
    private boolean isStarveDeath;
    private double kilogramFoodInStomach;

    public int getSpeedCellsMovement() {
        return speedCellsMovement;
    }
    public void setSpeedCellsMovement(int speedCellsMovement) {
        this.speedCellsMovement = speedCellsMovement;
    }

    public double getKilogramsFoodForFullSaturation() {
        return kilogramsFoodForFullSaturation;
    }
    public void setKilogramsFoodForFullSaturation(double kilogramsFoodForFullSaturation) {
        this.kilogramsFoodForFullSaturation = kilogramsFoodForFullSaturation;
    }

    public boolean isStarveDeath() {
        return isStarveDeath;
    }
    public void setStarveDeath(boolean starveDeath) {
        isStarveDeath = starveDeath;
    }

    public double getKilogramFoodInStomach() {
        return kilogramFoodInStomach;
    }
    public void setKilogramFoodInStomach(double kilogramFoodInStomach) {
        this.kilogramFoodInStomach = kilogramFoodInStomach;
    }
}
