package com.company.devices;

public class Car {
    public final String model;
    public final String producent;
    public String color;
    private Double price = 1000.;
    private Double millage;

    public Car(String model, String producent){
        this.model = model;
        this.producent = producent;
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return producent + " " + model;
    }
}
