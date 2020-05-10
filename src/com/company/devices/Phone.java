package com.company.devices;

import com.company.Human;
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

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if (seller.phone != this)
            throw new Exception("The seller does not own this phone");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.phone = null;
            buyer.phone = this;
            seller.cash += price;
            buyer.cash -= price;
            System.out.println("Sold this phone: " + this.toString());
        }
    }
}
