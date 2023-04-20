package org.gfa.inheritancezoo;

public class Elephant extends Animal {
  private boolean hasTusks;

  public Elephant(String name, int age, double weight, String gender, boolean hasTusks) {
    // nohou má obvykle 4
    // není fluffy

    //Animal animal = new Animal(4, false, name, age, weight, gender);
    super(4, false, name, age, weight, gender);
    this.hasTusks = hasTusks;

  }

  public boolean isHasTusks() {
    return hasTusks;
  }

  public void setHasTusks(boolean hasTusks) {
    this.hasTusks = hasTusks;
  }

  public void stomp() {
    System.out.println("Im stomping.");
  }
}
