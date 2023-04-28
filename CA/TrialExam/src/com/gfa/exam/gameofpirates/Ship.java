package com.gfa.exam.gameofpirates;

import com.gfa.exam.gameofpirates.pirates.Captain;
import com.gfa.exam.gameofpirates.pirates.Pirate;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Pirate> crew = new ArrayList<>();
    private boolean hasCaptain = false;

    public boolean addPirate(Pirate p) {
        // variable name `p` is acceptable here because it's the only one,
        // dare to say obvious one, and it's such a short method
        if (p instanceof Captain) {
            if (hasCaptain) return false;
            hasCaptain = true;
        }
        return crew.add(p);
    }

    public int getCrewSize() {
        return crew.size();
    }

    public List<String> getPoorPirates() {
        List<String> names = new ArrayList<>();

        for (Pirate p : crew) {
            if (p.isPoor()) {
                names.add(p.getName());
            }
        }

        return names;
    }

    public int getTotalGold() {
        int sum = 0;

        for (Pirate p : crew) {
            sum += p.getGoldAmount();
        }

        return sum;
    }

    public void lastDayOnTheShip() {
        for (Pirate p : crew) {
            p.party();
        }
    }

    public void prepareForBattle() {
        for (Pirate p : crew) {
            p.work().work().work().work().work();
        }

        lastDayOnTheShip();
    }
}
