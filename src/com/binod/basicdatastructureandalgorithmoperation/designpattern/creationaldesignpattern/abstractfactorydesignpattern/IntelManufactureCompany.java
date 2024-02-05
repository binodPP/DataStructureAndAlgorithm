package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class IntelManufactureCompany implements ManufactureCompany {
    private String brand;
    public IntelManufactureCompany(String brand) {
        this.brand = brand;
    }
    @Override
    public String brand() {
        return brand;
    }
}
