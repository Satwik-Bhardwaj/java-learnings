package org.example.designPatterns.factoryMethodDP;

interface Automobile {
    void drive();
}

class Tank implements Automobile {

    @Override
    public void drive() {
        System.out.println("Army drives a tank!");
    }
}

class Car implements Automobile {

    @Override
    public void drive() {
        System.out.println("Car drives by normal citizens.");
    }
}

interface Driver {

    Automobile createAutomobile();

    default void getThemVehicle() {
        Automobile automobile = createAutomobile();
        automobile.drive();
    }
}

class DefenseDriver implements Driver {

    @Override
    public Automobile createAutomobile() {
        return new Tank();
    }
}

class NormalDriver implements Driver {

    @Override
    public Automobile createAutomobile() {
        return new Car();
    }
}

public class FactoryMethodDesignPattern {
    public static void main(String[] args) {
        Driver driver = new DefenseDriver();
        driver.getThemVehicle();

        Driver driver1 = new NormalDriver();
        driver1.getThemVehicle();
    }
}
