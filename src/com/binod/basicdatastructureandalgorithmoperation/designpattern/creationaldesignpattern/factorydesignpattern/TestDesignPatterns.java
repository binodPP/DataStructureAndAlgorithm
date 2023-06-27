package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.factorydesignpattern;


public class TestDesignPatterns {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC","2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("SERVER","16 GB","1 TB","2.9 GHz");
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
