package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class ComputerFactoryEntryClass {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
