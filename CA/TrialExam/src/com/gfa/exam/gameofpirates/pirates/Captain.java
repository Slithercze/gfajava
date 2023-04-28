package com.gfa.exam.gameofpirates.pirates;

public class Captain extends Pirate {
    public Captain(String name) {
        super(name);
    }

    @Override
    public Pirate work() {
        goldAmount += 4;
        healthPoints -= 3;

        return this;
    }

    @Override
    public void party() {
        healthPoints += 5;
    }
}
