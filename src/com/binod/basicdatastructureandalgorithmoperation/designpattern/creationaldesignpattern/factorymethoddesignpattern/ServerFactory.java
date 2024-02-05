package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.factorymethoddesignpattern;

public class ServerFactory implements ComputerFactory{
    @Override
    public Computer createCompute(String ram, String hdd, String cpu) {
        return new Server(ram,hdd,cpu);
    }
}
