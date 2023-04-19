package org.gfa.oopmr;

public class Human {
    public static void main(String[] args) { // static method, can be called ONLY by Human.main()
        System.out.println("lol");
        System.out.println(POPULATION_COUNTER);
    }

    public static int POPULATION_COUNTER; // static, accessed from Human.POPULATION_COUNTER

    public final static double PI = 3.14; // constant, static access from anywhere


    // fields for created instances below:
    private int age;
    private Pet pet;
    private int amountOfEyes;
    private String name;
    private boolean canWalk = true;
    public int ears; //!!!!!!!!!!!!!!!!!! usually not good practice

    public Human(int age, int amountOfEyes, String name) {
        // constructor creates new instances
        this.age = age;
        this.amountOfEyes = amountOfEyes;
        this.name = name;
        this.pet = new Pet("tapka");

        // incrementing static member to count how many instances were created
        // this is not a common thing, to manipulate static fields in a constructor, for educational purposes only
        POPULATION_COUNTER++;
    }

    public Human(int age, int amountOfEyes) {
//        this.age = age;
//        this.amountOfEyes = amountOfEyes;
//        this.name = "ales";
        // constructor chaining
        this(age, amountOfEyes, "ales"); // also calls constructor on line 10, simply passes parameters to it
    }

    public Human() {
        // default values, simply pass them to another constructor
        this(420, 7, "ales"); // calls constructor on line 10
    }

    // method
    public void fallFromStairs() {
        walk();
        pet.makeSound();
        canWalk = false;
    }

    public void walk() {
        int cokoliv = 5;
        System.out.println(cokoliv);
        if (canWalk) {
            System.out.println("I am walking.");
        }
    }

    // getter
    public boolean canWalk() {
        return canWalk;
    }

    // commented out setter, so canWalk is read-only
//    public void setCanWalk(boolean canWalk) {
//        this.canWalk = canWalk;
//    }

    // getter
    public int getAmountOfEyes() {
        return amountOfEyes;
    }

    // setter
    public void setAmountOfEyes(int amountOfEyes) {
        if (amountOfEyes <= 4) {
            this.amountOfEyes = amountOfEyes;
        } else {
            System.out.println("Maximum amount of eyes is 4");
        }
    }
}
