package com.company.devices;

import com.company.Saleable;

public abstract class Device implements Saleable {
    private String producer;
    private String model;
    private Integer yearOfProduction;
    public Double value = 0.0;

    public Device(String producer, String model, Integer yearOfProduction) {
        setModel(model);
        setProducer(producer);
        setYearOfProduction(yearOfProduction);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return producer + " " + model + " " + yearOfProduction + " "+ value;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public abstract void turnOn();

    public abstract boolean isPowered();

}
