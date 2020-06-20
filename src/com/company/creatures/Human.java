package com.company.creatures;

import com.company.Main;
import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.Arrays;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    public Phone phone;
    public Animal pet;
    public FarmAnimal farmAnimal;
    public Car[] garage;
    private Double salary = 2000.;
    public Double cash = 1000.;

    public Human() {
        this(5);

    }

    public Human(int garageSize) {
        super("homo sapiens");
        this.weight = 80.0;
        this.garage = new Car[garageSize];
    }

    public Car getCar(int pos) {
        return garage[pos];
    }

    public void setCar(Car car, int pos) {
        this.garage[pos] = car;
    }

    public void printCarList() {
        Double totalValue = 0.0;
        System.out.println("Car list of "+this);
        for (int i = 0; i < this.garage.length; i++) {
            System.out.println(i+". "+this.garage[i]);
        }
    }

    public Double getTotalCarValue() {
        Double totalValue = 0.0;
        for (Car car : this.garage) {
            if (car != null)
                totalValue += car.value;
        }

        return totalValue;
    }

    public int getFirstFreeSlotInGarage() {
        return Main.find(this.garage,null);
    }

    public void sortCars() {
        Arrays.sort(this.garage, (a, b) -> {
            Integer aValue = Integer.MAX_VALUE;
            Integer bValue = Integer.MAX_VALUE;
            if (a != null)
                aValue = a.getYearOfProduction();
            if (b != null)
                bValue = b.getYearOfProduction();
            return aValue - bValue;
        });
    }

    public void buyCar(Car car) {
        int freeSlot = this.getFirstFreeSlotInGarage();
        if (freeSlot < 0) {
            System.out.println("No free slots in garage");
        }
        else if (this.salary > car.value){
            System.out.println("Gratulacje you bought it");
            this.garage[freeSlot] = car;
        }
        else if ( this.salary > car.value/12.0) {
            System.out.println("You bought it, I mean your bank bought it, but it could be yours in the future");
            this.garage[freeSlot] = car;
        }
        else {
            System.out.println("Go to work man");
        }
    }

    void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Próbowano wpisać ujemną wypłatę");
            return;
        }
        this.salary = salary;
    }
    Double getSalary() {
        return salary;
    }
    public String toString() {
        return firstName + " " + lastName + " ";
    }
    @Override
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("Nope");
    }
}
