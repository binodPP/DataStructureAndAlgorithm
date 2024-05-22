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
public class Tripleton {

    /*private static Tripleton INSTANCE1;
    private static int  count= 0;

    private Tripleton() {
        count++;
    }

    public static synchronized Tripleton getInstance() {
        if (count < 3) {
            INSTANCE1 = new Tripleton();
        }
        return INSTANCE1;
    }
*/


    private static volatile Tripleton INSTANCE1;
    private static volatile Tripleton INSTANCE2;
    private static volatile Tripleton INSTANCE3;

    private Tripleton() {}

    public static Tripleton getInstance(int instanceNumber) {
        switch (instanceNumber) {
            case 1:
                if (INSTANCE1 == null) {
                    synchronized (Tripleton.class) {
                        if (INSTANCE1 == null) {
                            INSTANCE1 = new Tripleton();
                        }
                    }
                }
                return INSTANCE1;
            case 2:
                if (INSTANCE2 == null) {
                    synchronized (Tripleton.class) {
                        if (INSTANCE2 == null) {
                            INSTANCE2 = new Tripleton();
                        }
                    }
                }
                return INSTANCE2;
            case 3:
                if (INSTANCE3 == null) {
                    synchronized (Tripleton.class) {
                        if (INSTANCE3 == null) {
                            INSTANCE3 = new Tripleton();
                        }
                    }
                }
                return INSTANCE3;
            default:
                throw new IllegalArgumentException("Invalid instance number");
        }
    }


    public static void main(String[] args) {
        Tripleton multiThreadedWithPerformance1 = Tripleton.getInstance(1);
        Tripleton multiThreadedWithPerformance2 = Tripleton.getInstance(2);
        Tripleton multiThreadedWithPerformance3 = Tripleton.getInstance(3);
        //Tripleton multiThreadedWithPerformance4 = Tripleton.getInstance(4);
        //Tripleton multiThreadedWithPerformance5 = Tripleton.getInstance();
        //Tripleton multiThreadedWithPerformance6 = Tripleton.getInstance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance3: "+multiThreadedWithPerformance3.hashCode());
        //System.out.println("Hashcode of multiThreadedWithPerformance4: "+multiThreadedWithPerformance4.hashCode());
        //System.out.println("Hashcode of multiThreadedWithPerformance3: "+multiThreadedWithPerformance5.hashCode());
        //System.out.println("Hashcode of multiThreadedWithPerformance4: "+multiThreadedWithPerformance6.hashCode());

    }
}
