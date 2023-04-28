package com.gfa.exam.gameofpirates;

import com.gfa.exam.gameofpirates.pirates.Captain;
import com.gfa.exam.gameofpirates.pirates.Pirate;

public class Main {
    public static void main(String[] args) {
        Ship s = new Ship();

        Pirate p = new Pirate("whatever");
        Captain c = new Captain("iaersntieanrst");

        s.addPirate(p);
        s.addPirate(c);
    }
}
