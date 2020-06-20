package com.company.devices;

import com.company.Main;
import com.company.creatures.Human;

import java.util.Arrays;

public abstract class Car extends Device {
    public String color;
    private Double millage;
    private boolean turnedOn = false;

    public Car(String model, String producent, Integer yearOfProduction){
        super(model,producent, yearOfProduction);
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        System.out.println(" buyer cash: "+ buyer.cash + " seller cash: " + seller.cash);
        int sellerSlot = Main.find(seller.garage, this);
        int buyerSlot = buyer.getFirstFreeSlotInGarage();
        if (sellerSlot < 0)
            throw new Exception("The seller does not own this car");
        else if (buyer.getFirstFreeSlotInGarage() < 0)
            throw new Exception("No free space in garage");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.setCar(null, sellerSlot);
            buyer.setCar(this, buyerSlot);
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
