package com.company;

import java.io.File;
import java.io.Serializable;

public class Animal implements Edible, Saleable {
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

    @Override
    public void beEaten() {
        weight = 0.0;
        System.out.println("goodbye");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception{
        if (seller.pet != this)
            throw new Exception("The seller does not own this animal");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.pet = null;
            buyer.pet = this;
            seller.cash += price;
            buyer.cash -= price;
            System.out.println("Sold this animal: " + this.toString());
        }
    }
    public String toString() {
        return species + " " + name;
    }
}
