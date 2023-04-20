package org.gfa.inheritancezoo;

public class Bird extends Animal {
  public Bird(String name, int age, double weight, String gender) {
    super(2, false, name, age, weight, gender);
  }

  @Override
  public void makeSound() {
    System.out.println("Chirp chirp");
  }
}
