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
        Car oldElectric = new CarElectric("Electric", "Car", 2020);

        oldElectric.value = 1000.0;
        me.setCar(oldElectric,0);
        oldElectric.refuel();
        me.setCar(new CarElectric("Electric2", "Car", 2019),1);
        me.getCar(1).value = 2000.0;
        me.getCar(1).refuel();

        Phone nokia = new Phone("Nokia","3310",2019);
        nokia.turnOn();
        myWife.setPhone(nokia);
        try {
            nokia.sell(myWife,me,1000.);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Application app1 = new Application("Poczta","1.0",100.0);
        Application app2 = new Application("Internet","1.2",0.0);
        Application app3 = new Application("Pasjans","1.4",0.0);
        Application app4 = new Application("Zegar","1.0",25.0);
        nokia.installApp(app1);
        nokia.installApp(app2);
        nokia.installApp(app3);
        nokia.installApp(app4);

        System.out.println("Poczta zainstalowana " + nokia.isInstalled("Poczta"));
        System.out.println("Internet zainstalowany " + nokia.isInstalled(app2));
        nokia.printFreeApps();

        nokia.printAllAppsSortByName();
        nokia.printAllAppsSortByPrice();

        System.out.println("Ilość aplikacji: "+ nokia.getTotalAppsValue());
        System.out.println(nokia.isPowered());
        try {
            me.pet.sell(me, myWife, 100.);
        }
            catch (Exception e) {
            System.out.println(e.getMessage());
        }

        me.sell(myWife,new Human(),1000.);
        Human distantHuman = new Human();
        try {
            me.getCar(0).sell(me, distantHuman, 1.);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Sprzedałem samochód ludziowi: "+oldElectric.checkTransaction(distantHuman, me));
        System.out.println("transakcje: "+oldElectric.getTransactionCount());
        System.out.println("ma właściciela: "+oldElectric.hasOwner());

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
