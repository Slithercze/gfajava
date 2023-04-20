package org.gfa.dalsi; // this is where we are

import org.gfa.oopmr.Human; // import from another package

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Human ales =  new Human(); // new instance, NON-static

        int amountAfterAles = Human.POPULATION_COUNTER; // static access, at this point it will be 1

        Human lukas = new Human(30, 2, "lukas");
        int amountAfterLuky = Human.POPULATION_COUNTER; // also static, will be 2

        Human.main(new String[]{}); // call static method, string array only to satisfy the parameters
        Human lukasKubec = new Human(30, 2, "lukas");
        ales.ears = 420; // setting a public field, which is not a good design
        ales.setAmountOfEyes(420); // call NON-static method

        System.out.println(ales.getAmountOfEyes());
        System.out.println(lukas.getAmountOfEyes());

        String text = new String("ahoj"); // create an instance of class String
        text = text.replace("x", "a"); // call NON-static method replace

        int a = Math.abs(100); // call static method abs of class Math

    }
}