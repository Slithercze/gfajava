package org.gfa.inheritancezoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
  private List<Animal> animals;

  public Zoo(List<Animal> animals) {
    this.animals = animals;
  }

  public Zoo() {
    animals = new ArrayList<>();
  }

  public void addAnimal(Animal animal) {
    animals.add(animal);
  }

  public List<Animal> getAnimals() {
    return animals;

  }
}
