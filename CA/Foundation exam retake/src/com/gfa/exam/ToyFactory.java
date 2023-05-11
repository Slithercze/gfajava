package com.gfa.exam;

import java.util.Random;

public class ToyFactory {
  private int balance = 200;

  public Toy produce (String color, int size) {
    boolean randomizer = new Random().nextBoolean();
    Toy toy = null;
    if (randomizer) {
      toy = new DottedBall(color, size);
    } else {
      toy = new JumpingRope(color, size);
    }
    if (toy.getCost() > balance) {
      return null;
    }
    balance -= toy.getCost();
    return toy;
  }

  public Toy produce(String color) {
    Toy toy = new Doll(color);
    if (toy.getCost() > balance) {
      return null;
    }
    balance -= toy.getCost();
    return toy;
  }

}
