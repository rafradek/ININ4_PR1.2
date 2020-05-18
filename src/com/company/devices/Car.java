package com.company.devices;

import com.company.creatures.Human;

public abstract class Car extends Device {
    public String color;
    private Double price = 1000.;
    private Double millage;
    private boolean turnedOn = false;

    public Car(String model, String producent, Integer yearOfProduction){
        super(model,producent, yearOfProduction);
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        System.out.println(" buyer cash: "+ buyer.cash + " seller cash: " + seller.cash);
        if (seller.getCar() != this)
            throw new Exception("The seller does not own this car");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.setCar(null);
            buyer.setCar(this);
            seller.cash += price;
            buyer.cash -= price;
            System.out.println("Sold this car: " + this.toString() + " buyer cash: "+ buyer.cash + " seller cash: " + seller.cash);
        }
    }

    @Override
    public void turnOn() {
        if (turnedOn) {
            System.out.println("already turned on");
            return;
        }
        else if (this.getFuel() < 0) {
            System.out.println("Empty fuel tank, cannot turn on");
            return;
        }
        turnedOn = true;
    }

    @Override
    public boolean isPowered() {
        return turnedOn;
    }

    public abstract void refuel();

    public abstract Double getFuel();
}
