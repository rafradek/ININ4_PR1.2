package com.company.devices;

import com.company.Main;
import com.company.creatures.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Car extends Device {
    public String color;
    private Double millage;
    private boolean turnedOn = false;

    public List<Human> owners = new ArrayList<>();

    public Car(String model, String producent, Integer yearOfProduction){
        super(model,producent, yearOfProduction);
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        System.out.println(" buyer cash: "+ buyer.cash + " seller cash: " + seller.cash);
        int sellerSlot = Main.find(seller.garage, this);
        int buyerSlot = buyer.getFirstFreeSlotInGarage();
        if (sellerSlot < 0 || this.owners.get(this.owners.size()-1) != seller)
            throw new Exception("The seller does not own this car");
        else if (buyer.getFirstFreeSlotInGarage() < 0)
            throw new Exception("No free space in garage");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.setCar(null, sellerSlot);
            buyer.setCar(this, buyerSlot);
            this.owners.add(buyer);
            seller.cash += price;
            buyer.cash -= price;
            System.out.println("Sold this car: " + this.toString() + " buyer cash: "+ buyer.cash + " seller cash: " + seller.cash);
        }
    }

    public boolean hasOwner() {
        return this.owners.size() > 0;
    }

    public boolean checkTransaction(Human buyer, Human seller) {
        for (int i = 1; i < this.owners.size(); i++) {
            if (this.owners.get(i) == buyer && this.owners.get(i-1) == seller) {
                return true;
            }
        }
        return false;
    }

    public Integer getTransactionCount() {
        return this.owners.size()-1;
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
