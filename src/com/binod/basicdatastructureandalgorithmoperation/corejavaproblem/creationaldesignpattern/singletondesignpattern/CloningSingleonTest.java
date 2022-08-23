package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class CloningSingleonTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        ThreadSafeSingletonDoubleCheck instance1 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();
        ThreadSafeSingletonDoubleCheck instance2= (ThreadSafeSingletonDoubleCheck) instance1.clone();

        System.out.println("Hashcode of instance1: "+instance1.hashCode());
        System.out.println("Hashcode of instance2: "+instance2.hashCode());
    }
}
