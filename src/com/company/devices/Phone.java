package com.company.devices;

import sun.rmi.server.InactiveGroupException;

public class Phone extends Device{

    private Double screenSize;

    private Boolean turnedOn = false;

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
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
        return this.turnedOn;
    }
}
