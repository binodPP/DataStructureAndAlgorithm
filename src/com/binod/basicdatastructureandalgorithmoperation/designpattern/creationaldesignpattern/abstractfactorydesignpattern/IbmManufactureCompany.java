package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

import com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern.Computer;

public class IbmManufactureCompany implements ManufactureCompany {
    private String brand;
    public IbmManufactureCompany(String brand) {
        this.brand = brand;
    }

    @Override
    public String brand() {
        return brand;
    }
}
