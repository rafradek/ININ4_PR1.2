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
        me.car = new Car("somemodel", "somemanufacturer");
        me.pet.feed();
        System.out.println(me.pet.species);
        System.out.println(me.car.model);

        me.pet = new Animal("Lion");
        me.pet.name = "Myszojeleń";

        me.pet.feed();

        System.out.println(me.pet.species);

        Animal cat = new Animal("cat");
        cat.feed();
        for (int i =0 ; i < 13; i++ ){
            cat.takeForAWalk();
        }
        cat.feed();
        cat.feed();
    }
}
