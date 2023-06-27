package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class TestDesignPatterns {
    public static void main(String[] args) {
        Computer pc = ComputerFactoryEntryClass.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer server = ComputerFactoryEntryClass.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc.getCPU());
        System.out.println("AbstractFactory Server Config::"+server.getCPU());
    }
}
