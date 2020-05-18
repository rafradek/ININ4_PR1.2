package com.company.devices;

public class CarLPG extends Car {
    public Double fuel = 0.;
    public Double maxFuel = 30.;

    public CarLPG(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    @Override
    public void refuel() {
        this.fuel = this.maxFuel;
        System.out.println("Refueled LPG car");
    }

    @Override
    public Double getFuel() {
        return fuel;
    }
}
