package com.gfa.exam.gameofpirates.pirates;

public class Pirate {
    private String name;
    protected int goldAmount;
    protected int healthPoints;
    private boolean hasWoodenLeg;

    public Pirate(String name) {
        this.name = name;
        this.goldAmount = 0;
        this.healthPoints = 20;
        this.hasWoodenLeg = Math.random() > 0.5;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public String getName() {
        return name;
    }

    public boolean isPoor() {
        return hasWoodenLeg && goldAmount < 15;
    }

    public Pirate work() {
        goldAmount++;
        healthPoints--;

        return this;
    }

    public void party() {
        healthPoints++;
    }

    @Override
    public String toString() {
        return String.format("Hello, I'm %s. I %s and %d amount of gold.",
                name,
                hasWoodenLeg ? "have a wooden leg" : "still have my real legs",
                goldAmount);
    }
}
