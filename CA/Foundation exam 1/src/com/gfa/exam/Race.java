package com.gfa.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
  private List<Contestant> contestants;
  private List<Player> players;

  public Race(List<Contestant> contestants, List<Player> players) {
    this.contestants = contestants;
    this.players = players;
  }

  public void startRace() {
    Collections.sort(contestants);
    for (int i = 0; i < contestants.size(); i++) {
      contestants.get(i).setPlacement(i + 1);
      System.out.println(contestants.get(i));
    }

    for (Player p : players) {
      for (Bet bet : p.getBets()) {
        if (bet.getContestant().getPlacement() == 1) {
          System.out.println(
              p.getName() + " has won " + 2 * bet.getAmount() + "$ with the bet: " +
                  bet.getBetId());
          p.addMoney(2 * bet.getAmount());
        }
      }
    }
  }

  public static void main(String[] args) {
    List<Contestant> contestants = new ArrayList<>();
    contestants.add(new Contestant("Contestant 1"));
    contestants.add(new Contestant("Contestant 2"));
    contestants.add(new Contestant("Contestant 3"));

    List<Player> players = new ArrayList<>();
    players.add(new Player("Player 1", 1000));
    players.add(new Player("Player 2", 2000));
    players.add(new Player("Player 3", 3000));
    players.add(new Player("Player 4", 1000));

    players.get(0).makeBet(contestants.get(0), 500);
    players.get(1).makeBet(contestants.get(1), 500);
    players.get(2).makeBet(contestants.get(2), 5000);
    players.get(2).makeBet(contestants.get(2), 1000);
    players.get(3).makeBet(contestants.get(1), 1000);

    new Race(contestants, players).startRace();

  }

}
