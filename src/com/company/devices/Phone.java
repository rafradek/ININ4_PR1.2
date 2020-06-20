package com.company.devices;

import com.company.creatures.Human;

import java.util.*;

public class Phone extends Device{

    private static final String DEFAULT_VERSION = "1.0";
    private static final String DEFAULT_URL = "localhost";
    private static final String DEFAULT_PROTOCOL = "https://";

    private Set<Application> applications = new HashSet<>();
    private Double screenSize;

    private Boolean turnedOn = false;

    private Human owner;

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
        if (seller.getPhone() != this)
            throw new Exception("The seller does not own this phone");
        else if (buyer.cash < price)
            throw new Exception("come back when you're a little mmm richer");
        else {
            seller.setPhone(null);
            buyer.setPhone(this);
            seller.cash += price;
            buyer.cash -= price;
            System.out.println("Sold this phone: " + this.toString());
        }
    }

    public void installApp(Application app) {
        if (this.getOwner() == null) {
            System.out.println("Unowned phone, cant install app");
        }
        else if (this.getOwner().cash < app.price) {
            System.out.println("Cannot buy app, not enough money");
        }
        else {
            getOwner().cash -= app.price;
            this.applications.add(app);
        }
    }

    public boolean isInstalled(Application application) {
        return this.applications.contains(application);
    }

    public boolean isInstalled(String appName) {
        for (Application application : this.applications) {
            if (application.name.equals(appName))
                return true;
        }
        return false;
    }

    public void printFreeApps() {
        for (Application application : this.applications) {
            if (application.price == 0.0) {
                System.out.println(application.name);
            }
        }
    }

    public void printAllAppsSortByName() {
        Application[] byName = this.applications.toArray(new Application[this.applications.size()]);
        Arrays.sort(byName, Comparator.comparing(a -> a.name));
        for (Application application: byName) {
            System.out.println(application.name);
        }
    }

    public void printAllAppsSortByPrice() {
        Application[] byPrice = this.applications.toArray(new Application[this.applications.size()]);
        Arrays.sort(byPrice, Comparator.comparing(a -> a.price));
        for (Application application: byPrice) {
            System.out.println(application.name);
        }
    }

    public Double getTotalAppsValue() {
        Double value = 0.0;
        for (Application application : this.applications) {
            value += application.price;
        }
        return value;
    }


    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

//    public void installAnApp(String name) {
//        installAnApp(name, DEFAULT_VERSION);
//    }
//
//    public void installAnApp(String name, String version) {
//        installAnApp(name, DEFAULT_VERSION, DEFAULT_PROTOCOL+ DEFAULT_URL);
//
//    }
//
//    public void installAnApp(String name, String version, String url) {
//
//    }
//
//    public void installAnApp(List<String> names) {
//        for (String name:
//             names) {
//            installAnApp(name);
//        }
//    }
//
//    public void installAnApp(URL url) {
//        installAnApp(url);
//    }
}
