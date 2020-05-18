package com.company.devices;

public class CarElectric extends Car {
    public Double charge = 0.;
    public Double maxCharge = 50.;
    public CarElectric(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    @Override
    public void refuel() {
        this.charge = this.maxCharge;
        System.out.println("Recharged electric car");
    }

    @Override
    public Double getFuel() {
        return charge;
    }
}
