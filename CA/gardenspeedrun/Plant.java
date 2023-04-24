package gardenspeedrun;

public abstract class Plant {
    private double waterLevel;
    private double absorptionCoef;
    private int waterLevelTreshold;
    private String color;

    public Plant(double absorptionCoef, int waterLevelTreshold, String color) {
        this.waterLevel = 0;
        this.absorptionCoef = absorptionCoef;
        this.waterLevelTreshold = waterLevelTreshold;
        this.color = color;
    }

    public void absorbWater(double amount) {
        waterLevel += amount * absorptionCoef;
    }

    public boolean needsWater() {
        return waterLevel < waterLevelTreshold;
    }

    @Override
    public String toString() {
        return "The " + color + " " + getClass().getSimpleName() +
                (needsWater() ? " needs water" : " doesn't need wasser");
    }
}
