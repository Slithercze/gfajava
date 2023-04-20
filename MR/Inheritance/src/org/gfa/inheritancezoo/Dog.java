package org.gfa.inheritancezoo;

public class Dog extends Animal {

  public Dog(boolean isFluffy, String name, int age, double weight, String gender) {
    super(4, isFluffy, name, age, weight, gender);
  }

  @Override
  public void makeSound() {
    super.makeSound();
    System.out.println("Roof!");
  }

  public void bite() {
    System.out.println("Im biting");
  }
}
