package com.company;

import java.io.File;

public class Animal {
    final String species;
    String name;
    File pic;
    protected Double weight;

    static final Double DOG_WEIGHT = 10.;
    static final Double LION_WEIGHT = 180.;
    static final Double DEFAULT_WEIGHT = 1.;

    public Animal(String species) {
        this.species = species;
        if (species == "Dog") {
            weight = DOG_WEIGHT;
        } else if (species == "Lion") {
            weight = LION_WEIGHT;
        } else {
            weight = DEFAULT_WEIGHT;
        }

    }

    void feed() {
        if (weight <= 0.){
            System.out.println("The "+ species +" is dead");
        }
        else {
            weight += 0.1;
            System.out.println("Thx bro, my weight is now " + weight);
        }
    }

    void takeForAWalk() {
        if (weight <= 0.){
            System.out.println("The "+ species +" is dead");
        }
        else {
            weight -= 0.1;
            System.out.println("Current weight " + weight);
        }
    }
}
