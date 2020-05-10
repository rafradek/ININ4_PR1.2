package com.company.devices;

import com.company.Human;

public class Car extends Device {
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
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getCar() != this)
            System.out.println("The seller does not own this car");
        else if (buyer.cash < price)
            System.out.println("come back when you're a little mmm richer");
        seller.setCar(null);
        buyer.setCar(this);
        seller.cash += price;
        buyer.cash -= price;
        System.out.println("Sold this car: "+this.toString());
    }

    @Override
    public void turnOn() {
        if (turnedOn) {
            System.out.println("already turned on");
            return;
        }
        turnedOn = true;
    }

    @Override
    public boolean isPowered() {
        return turnedOn;
    }
}
