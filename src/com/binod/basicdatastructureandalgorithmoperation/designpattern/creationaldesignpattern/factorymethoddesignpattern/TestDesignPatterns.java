package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.factorymethoddesignpattern;


public class TestDesignPatterns {
    public static void main(String[] args) {
        ComputerFactory pcComputerFactory = new PcFactory();
        Computer pc = pcComputerFactory.createCompute("2 GB","500 GB","2.4 GHz");

        ComputerFactory serverComputerFactory = new ServerFactory();
        Computer server = serverComputerFactory.createCompute("16 GB","1 TB","2.9 GHz");
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
