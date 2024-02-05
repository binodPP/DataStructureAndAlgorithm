package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class Server implements Computer{
    private String ram;

    public Server(String ram) {
        this.ram = ram;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }
}
