package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.factorymethoddesignpattern;

public class PcFactory implements ComputerFactory{

    @Override
    public Computer createCompute(String ram, String hdd, String cpu) {
        return new PC(ram,hdd,cpu);
    }
}
