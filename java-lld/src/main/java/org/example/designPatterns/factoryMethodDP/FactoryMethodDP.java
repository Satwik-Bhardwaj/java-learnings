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

interface AutomobileFactory {

    Automobile produceAutomobile();

    default Automobile manufactureAutomobile() {
        Automobile automobile = produceAutomobile();
        automobile.drive();
        /* some operation */
        return automobile;
    }
}

class DefenseAutomobileFactory implements AutomobileFactory {

    @Override
    public Automobile produceAutomobile() {
        return new Tank();
    }
}

class NormalAutomobileFactory implements AutomobileFactory {

    @Override
    public Automobile produceAutomobile() {
        return new Car();
    }
}

public class FactoryMethodDP {
    public static void main(String[] args) {

        AutomobileFactory normalAutomobileFactory = new NormalAutomobileFactory();
        Automobile car = normalAutomobileFactory.manufactureAutomobile();

        AutomobileFactory defenseAutomobileFactory = new DefenseAutomobileFactory();
        Automobile tank = defenseAutomobileFactory.manufactureAutomobile();

    }
}
