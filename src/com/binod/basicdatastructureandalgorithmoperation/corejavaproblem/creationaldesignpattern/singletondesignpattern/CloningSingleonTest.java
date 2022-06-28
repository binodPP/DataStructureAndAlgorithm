package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class CloningSingleonTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BillPughSingleton instance1 = BillPughSingleton.getInstanceBillPughSingleton();
        BillPughSingleton instance2=(BillPughSingleton) instance1.clone();

        System.out.println("Hashcode of instance1: "+instance1.hashCode());
        System.out.println("Hashcode of instance2: "+instance2.hashCode());
    }
}
