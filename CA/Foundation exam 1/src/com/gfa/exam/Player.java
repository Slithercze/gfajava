package com.gfa.exam;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int account;
  private List<Bet> bets = new ArrayList<>();

  public Player(String name, int account) {
    this.name = name;
    this.account = account;
  }

  public void makeBet(Contestant contestant, int amount) {
    if (amount > this.account) {
      return;
    }
    bets.add(new Bet(amount, this, contestant));
    this.account -= amount;
  }

  public void addMoney(int amount) {
    if (amount < 0) {
      return;
    }
    account += amount;
  }

  public String getName() {
    return name;
  }

  public List<Bet> getBets() {
    return bets;
  }
}
