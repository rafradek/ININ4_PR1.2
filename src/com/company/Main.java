package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

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
        me.setCar(new Car("somemodel", "somemanufacturer",2010));
        me.getCar().color = "gray";
        me.getCar().turnOn();
        me.pet.feed();
        System.out.println(me.pet.species);
        System.out.println(me.getCar().getModel());
        System.out.println(me.getCar().isPowered());
        me.pet = new Animal("Lion");
        me.pet.name = "Myszojeleń";

        me.pet.feed();

        System.out.println(me.species);

        System.out.println(me.pet.species);

        Animal cat = new Animal("cat");
        cat.feed();
        for (int i =0 ; i < 13; i++ ){
            cat.takeForAWalk();
        }
        cat.feed();
        cat.feed();


        Human myWife = new Human();
        myWife.firstName = "Karolina";
        //myWife.setCar(new Car("somemodel","somemanufacturer",2010));
        try {
            me.getCar().sell(me,myWife,10000.);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Phone nokia = new Phone("Nokia","3310",2019);
        nokia.turnOn();
        myWife.phone = nokia;
        try {
            nokia.sell(myWife,me,1000.);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(nokia.isPowered());
        try {
            me.pet.sell(me, myWife, 100.);
        }
            catch (Exception e) {
            System.out.println(e.getMessage());
        }

        myWife.sell(me,new Human(),1000.);
    }
}
