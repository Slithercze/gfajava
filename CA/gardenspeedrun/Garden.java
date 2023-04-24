package gardenspeedrun;

import java.util.ArrayList;

public class Garden {
    private ArrayList<Plant> plants = new ArrayList<>();

    public void addPlant(Plant p) {
        plants.add(p);
    }

    public ArrayList<Plant> needyPlants() {
        ArrayList<Plant> needyPlants = new ArrayList<>();

        for (Plant p : plants) {
            if (p.needsWater()) {
                needyPlants.add(p);
            }
        }

        return needyPlants;
    }

    public void water(int amount) {
        ArrayList<Plant> needyPlants = needyPlants();

        for (Plant p : needyPlants) {
            p.absorbWater(amount / needyPlants.size());
        }

        System.out.println("Watering with " + amount);
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Plant plant : plants) {
            sb.append(plant + "\n");
        }

        return sb.toString();
    }
}
