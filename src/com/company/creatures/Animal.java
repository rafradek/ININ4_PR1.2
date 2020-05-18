package com.company.creatures;

import com.company.Saleable;

import java.io.File;

public abstract class Animal implements Saleable, Feedable {
    public final String species;
    public String name;
    public File pic;
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

    @Override
    public void feed() {
        if (weight <= 0.){
            System.out.println("The "+ species +" is dead");
        }
        else {
            weight += 0.1;
            System.out.println("Thx bro, my weight is now " + weight);
        }
    }

    @Override
    public void feed(Double foodWeight) {
        if (weight <= 0.){
            System.out.println("The "+ species +" is dead");
        }
        else {
            weight += foodWeight;
            System.out.println("Thx bro, my weight is now " + weight);
        }
    }

    public void takeForAWalk() {
        if (weight <= 0.){
            System.out.println("The "+ species +" is dead");
        }
        else {
            weight -= 0.1;
            System.out.println("Current weight " + weight);
        }
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
