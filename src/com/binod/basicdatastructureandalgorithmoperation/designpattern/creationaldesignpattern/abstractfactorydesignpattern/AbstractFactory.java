package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.abstractfactorydesignpattern;

//Summary:
//Factory Pattern: Useful when you have a super class with multiple subclasses, and you want to create an instance of one of the subclasses based on input or context.
//
//Factory Method Pattern: Useful when you want to delegate the responsibility of creating objects to subclasses, allowing them to alter the type of objects that will be created.
//
//Abstract Factory Pattern: Useful when you need to create families of related or dependent objects, and the system must be configured with multiple families of objects.
public interface AbstractFactory {
    public abstract Computer createComputer();
    public abstract ManufactureCompany manufactureCompany();
}
