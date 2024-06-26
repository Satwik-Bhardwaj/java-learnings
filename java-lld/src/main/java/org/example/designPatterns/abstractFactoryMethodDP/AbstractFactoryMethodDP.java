package org.example.designPatterns.abstractFactoryMethodDP;

interface Monitor {
    void assemble();
}

interface Gpu {
    void assemble();
}

class MsiMonitor implements Monitor {

    @Override
    public void assemble() {
        System.out.println("MSI monitor assembled");
    }
}

class AsusMonitor implements Monitor {

    @Override
    public void assemble() {
        System.out.println("Asus monitor assembled");
    }
}

class MsiGpu implements Gpu{

    @Override
    public void assemble() {
        // business logic relevant to MSI GPU
        System.out.println("Assembling MSI gpu");
    }
}

class AsusGpu implements Gpu{

    @Override
    public void assemble() {
        // business logic relevant to Asus GPU
        System.out.println("Assembling Asus gpu");
    }
}

abstract class Company {
    // business logic can be added here
    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();

    public Gpu assembleGpu() {
        Gpu gpu = createGpu();

        createGpu().assemble();
        return gpu;
    }

    public Monitor assembleMonitor() {
        Monitor monitor = createMonitor();

        createMonitor().assemble();
        return monitor;
    }
}

class MsiManufacturer extends Company {

    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

class AsusManufacturer extends Company {

    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}

public class AbstractFactoryMethodDP {

    public static void main(String[] args) {
        Company msiCompany = new MsiManufacturer();
        msiCompany.assembleGpu();
        msiCompany.assembleMonitor();

        Company asusCompany = new AsusManufacturer();
        asusCompany.assembleGpu();
        asusCompany.assembleMonitor();
    }
}