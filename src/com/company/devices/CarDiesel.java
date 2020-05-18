package com.company.devices;

public class CarDiesel extends Car {
    public Double fuel = 0.;
    public Double maxFuel = 30.;

    public CarDiesel(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    @Override
    public void refuel() {
        this.fuel = this.maxFuel;
        System.out.println("Refueled diesel car");
    }

    @Override
    public Double getFuel() {
        return fuel;
    }
}
