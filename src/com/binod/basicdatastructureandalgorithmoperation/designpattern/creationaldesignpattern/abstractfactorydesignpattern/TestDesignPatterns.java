package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

public class TestDesignPatterns {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new PCAndIbmFactory("2 GB", "IBM");
        System.out.println(abstractFactory);
        Computer pc = abstractFactory.createComputer();
        ManufactureCompany ibmCompany = abstractFactory.manufactureCompany();
        System.out.println(pc.getRAM());
        System.out.println(ibmCompany.brand());

        System.out.println("=====================================");

        AbstractFactory abstractFactory1 = new ServerAndIntelFactory("16 GB", "INTEL");
        System.out.println(abstractFactory1);
        Computer server = abstractFactory1.createComputer();
        ManufactureCompany intelCompany = abstractFactory1.manufactureCompany();
        System.out.println(server.getRAM());
        System.out.println(intelCompany.brand());
    }
}
