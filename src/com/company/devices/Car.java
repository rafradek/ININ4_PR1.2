package com.company.devices;

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
