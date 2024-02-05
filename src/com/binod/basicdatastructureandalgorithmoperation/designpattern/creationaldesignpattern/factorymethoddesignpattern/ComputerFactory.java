package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.factorymethoddesignpattern;

public interface ComputerFactory {
    Computer createCompute(String ram, String hdd, String cpu);
}
