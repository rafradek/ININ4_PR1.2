package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Pet("Dog");
        dog.name = "Szarik";

        System.out.println("Hi, I'm " + dog.name);

        dog.feed();

        Human me = new Human();
        me.firstName = "Adrian";
        me.lastName = "Warda";
        me.pet = dog;
        me.setCar(new CarLPG("somemodel", "somemanufacturer",2010),0);
        me.getCar(0).color = "gray";
        me.getCar(0).turnOn();
        me.getCar(0).refuel();
        me.getCar(0).turnOn();

        me.pet.feed();
        System.out.println(me.pet.species);
        System.out.println(me.getCar(0).getModel());
        System.out.println(me.getCar(0).isPowered());
        me.farmAnimal = new FarmAnimal("Lion");
        me.farmAnimal.name = "Myszojeleń";

        me.farmAnimal.feed();
        me.farmAnimal.feed(444.);
        me.farmAnimal.beEaten();

        System.out.println(me.species);

        System.out.println(me.pet.species);

        Animal cat = new Pet("cat");
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
            me.getCar(0).sell(me,myWife,10000.);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        me.setCar(new CarElectric("Electric", "Car", 2020),0);
        me.getCar(0).value = 1000.0;
        me.getCar(0).refuel();
        me.setCar(new CarElectric("Electric2", "Car", 2019),1);
        me.getCar(1).value = 2000.0;
        me.getCar(1).refuel();

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

        me.sell(myWife,new Human(),1000.);

        try {
            me.getCar(0).sell(me, new Human(), 1.);
        } catch (Exception e) {
            e.printStackTrace();
        }
        me.setCar(new CarDiesel("Diesel", "Car", 2020),0);
        me.getCar(0).value = 1000.0;
        me.getCar(0).refuel();
        me.sortCars();
        me.printCarList();
        myWife.printCarList();
    }

    public static int find(Object[] array, Object object) {
        for (int i = 0; i < array.length; i++) {
            if (object == array[i])
                return i;
        }
        return -1;
    }
}
