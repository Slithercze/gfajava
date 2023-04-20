package org.gfa.inheritancezoo;

public class Animal {
  private String name;
  private int age = 0;
  private double weight;

  // !!
  private boolean isFluffy;

  private int legs;
  private String gender;

  public Animal(int legs, boolean isFluffy, String name, int age, double weight, String gender) {
    this.legs = legs;
    this.isFluffy = isFluffy;
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.gender = gender;
  }

  public void eat() {
    System.out.println("Im eating");
  }

  public void sleep() {
    System.out.println("Zzzzz");
  }

  public void move() {
      System.out.println("Im walking");

  }

  public void makeSound() {
    System.out.println("Im doing sound");
  }

  @Override
  public String toString() {
    return "I am: " + name + " and I am " + age + " years old and " + (isFluffy ? "I am fluffy" : "I am not fluffy");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public boolean isFluffy() {
    return isFluffy;
  }

  public void setFluffy(boolean fluffy) {
    isFluffy = fluffy;
  }

  public int getLegs() {
    return legs;
  }

  public void setLegs(int legs) {
    this.legs = legs;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
