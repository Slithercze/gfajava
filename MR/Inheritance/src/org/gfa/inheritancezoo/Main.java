package org.gfa.inheritancezoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {


    Dog punta = new Dog(true, "Punťa", 1, 1.0, "Male");
    Animal zofka = new Dog(true, "Žofka", 1, 1.0, "Female");
    Animal macka = new Cat("Macka", 4, 0.5, "Female");
    Animal alica = new Earthworm(false, "Alica", 0, 0.1, "Female");
    Animal ales = new Elephant("Aleš", 20, 4500, "Male", true);
    Animal elon = new Bird("Tweety", 2, 0.1, "Neutral");

    List<Animal> animals = new ArrayList<>();
    animals.add(punta);
    animals.add(macka);
    animals.add(zofka);
    animals.add(alica);
    animals.add(ales);
    animals.add(elon);
    System.out.println(animals.size());
    List<Dog> dogs = new ArrayList<>();
    List<Cat> cats = new ArrayList<>();
    List<Earthworm> earthworms = new ArrayList<>();
    List<Elephant> elephants = new ArrayList<>();
    List<Bird> birds = new ArrayList<>();

    for (Animal animal : animals) {
      if (animal instanceof Dog) {
        dogs.add((Dog) animal);
      }
      if (animal instanceof Cat) {
        cats.add((Cat) animal);
      }
      if (animal instanceof Earthworm) {
        earthworms.add((Earthworm) animal);
      }
      if (animal instanceof Elephant) {
        elephants.add((Elephant) animal);
      }
      if (animal instanceof Bird) {
        birds.add((Bird) animal);
      }
    }


    System.out.println(
        birds.size() +
            elephants.size() +
            dogs.size() +
            cats.size() +
            earthworms.size() +
            animals.size()
    );

    makeSound(punta);

  }

  public static void makeSound(Animal animal) {
    animal.makeSound();
  }
}
