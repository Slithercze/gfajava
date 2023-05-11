package com.gfa.exam;

public abstract class Toy {
  private int cost;
  private String color;
  private String owner;

  public Toy(int cost, String color) {
    this.cost = cost;
    this.color = color;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
