package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class ServerAndIntelFactory implements AbstractFactory {
    private String ram;
    private String brand;

    public ServerAndIntelFactory(String ram, String brand){
        this.ram=ram;
        this.brand=brand;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram);
    }

    @Override
    public ManufactureCompany manufactureCompany() {
        return new IntelManufactureCompany(brand);
    }

    @Override
    public String toString() {
        return "ServerAndIntelFactory{" +
                "ram='" + ram + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
