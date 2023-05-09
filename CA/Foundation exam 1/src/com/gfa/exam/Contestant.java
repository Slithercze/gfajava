package com.gfa.exam;

import java.util.Random;

public class Contestant implements Comparable<Contestant> {
  private String name;
  private int placement = 0;

  public Contestant(String name) {
    this.name = name;
  }

  public int getPlacement() {
    return placement;
  }

  public void setPlacement(int placement) {
    if (placement < 0) {
      return;
    }
    this.placement = placement;
  }

  @Override
  public String toString() {
    return this.name + " has finished on place: " + this.placement;
  }

  @Override
  public int compareTo(Contestant o) {
    return new Random().nextInt(3) - 1;
  }
}
