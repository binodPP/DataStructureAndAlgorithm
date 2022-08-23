package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.abstractfactorydesignpattern;

public class ComputerFactoryEntryClass {

    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
