package com.company;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Animal("Dog");
        dog.name = "Szarik";

        System.out.println("Hi, I'm " + dog.name);

        dog.feed();

        Human me = new Human();
        me.firstName = "Adrian";
        me.lastName = "Warda";
        me.pet = dog;

        me.pet.feed();
        System.out.println(me.pet.species);

        me.pet = new Animal("Lion");
        me.pet.name = "Myszojeleń";

        me.pet.feed();

        System.out.println(me.pet.species);
    }
}
