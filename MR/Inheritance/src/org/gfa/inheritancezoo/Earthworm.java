package org.gfa.inheritancezoo;

public class Earthworm extends Animal {
  public static void main(String[] args) {
    Earthworm earthworm = new Earthworm(false, "Žofka", 0, 0.1, "Female");
    earthworm.move();
  }

  public Earthworm(boolean isFluffy, String name, int age, double weight, String gender) {
    super(0, isFluffy, name, age, weight, gender);
  }

  @Override
  public void move() {
    System.out.println("Im crawling");
  }
}
