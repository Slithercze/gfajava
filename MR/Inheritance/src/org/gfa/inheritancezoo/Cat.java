package org.gfa.inheritancezoo;

public class Cat extends Animal {
  public Cat(String name, int age, double weight, String gender) {
    super(4, true, name, age, weight, gender);
  }

  @Override
  public void makeSound() {
    System.out.println("Meow");
  }
}
