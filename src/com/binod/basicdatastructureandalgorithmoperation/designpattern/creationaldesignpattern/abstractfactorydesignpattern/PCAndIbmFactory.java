package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class PCAndIbmFactory implements AbstractFactory {
    private String ram;
    private String brand;

    public PCAndIbmFactory(String ram, String brand){
        this.ram=ram;
        this.brand = brand;
    }
    @Override
    public Computer createComputer() {
        return new PC(ram);
    }

    @Override
    public ManufactureCompany manufactureCompany() {
        return new IbmManufactureCompany(brand);
    }

    @Override
    public String toString() {
        return "PCAndIbmFactory{" +
                "ram='" + ram + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
