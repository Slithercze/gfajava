package com.gfa.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Santa {
  private ToyFactory factory;
  private List<Toy> bag = new ArrayList<>();
  private List<String> children;

  public Santa(ToyFactory factory, List<String> children) {
    this.factory = factory;
    this.children = children;
  }

  public void addToyToBag(String color, int size) {
    Toy toy = null;
    if (new Random().nextBoolean()) {
      toy = factory.produce(color);
    } else {
      toy = factory.produce(color, size);
    }
    if (toy != null) {
      bag.add(toy);
    }
  }

  public void bringToChildren(List<String> names) {
    if (names != null) {
      Random random = new Random();
      while (names.size() != 0 && bag.size() != 0) {
        String owner = names.get(random.nextInt(names.size()));
        bag.get(0).setOwner(owner);
        bag.remove(0);
        names.remove(owner);
        children.remove(owner);
      }
    }
  }
}
