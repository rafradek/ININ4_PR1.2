package com.company.devices;

import com.company.creatures.Human;

import java.net.URL;
import java.util.List;

public class Phone extends Device{

    private static final String DEFAULT_VERSION = "1.0";
    private static final String DEFAULT_URL = "localhost";
    private static final String DEFAULT_PROTOCOL = "https://";
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

    public void installAnApp(String name) {
        installAnApp(name, DEFAULT_VERSION);
    }

    public void installAnApp(String name, String version) {
        installAnApp(name, DEFAULT_VERSION, DEFAULT_PROTOCOL+ DEFAULT_URL);

    }

    public void installAnApp(String name, String version, String url) {

    }

    public void installAnApp(List<String> names) {
        for (String name:
             names) {
            installAnApp(name);
        }
    }

    public void installAnApp(URL url) {
        installAnApp(url);
    }
}
