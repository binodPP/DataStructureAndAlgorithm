package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.singletondesignpattern;

//Violation of Singleton Principles
//Instance Control:
//Singleton: Ensures a single instance.
//Doubleton/Tripleton: Allows two or three instances, respectively.

//Global Access Point:
//Singleton: Provides a single global access point.
//Doubleton/Tripleton: Provides a controlled number of global access points.

//Use Case:
//Singleton: Best for resources that should not be duplicated, such as configuration settings, logging, or connection pooling.
//Doubleton/Tripleton: Useful in scenarios where exactly two or three instances are beneficial, such as load balancing between a fixed number of resources.
public class Doubleton {
    private static volatile Doubleton INSTANCE1;
    private static volatile Doubleton INSTANCE2;
    private static int call = 0;
    private Doubleton() {
    }
    public static Doubleton getInstance() {
        if (call++ % 2 == 0) {
            if (INSTANCE1 == null) {
                synchronized (Doubleton.class) {
                    if (INSTANCE1 == null) {
                        INSTANCE1 = new Doubleton();
                    }
                }
            }
            return INSTANCE1;
        } else {
            if (INSTANCE2 == null) {
                synchronized (Doubleton.class) {
                    if (INSTANCE2 == null) {
                        INSTANCE2 = new Doubleton();
                    }
                }
            }
            return INSTANCE2;
        }
    }

    public static void main(String[] args) {
        Doubleton multiThreadedWithPerformance1 = Doubleton.getInstance();
        Doubleton multiThreadedWithPerformance2 = Doubleton.getInstance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());

    }
}
