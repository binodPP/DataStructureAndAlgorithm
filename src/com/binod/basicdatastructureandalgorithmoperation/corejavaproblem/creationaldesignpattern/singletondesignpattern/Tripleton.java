package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class Tripleton {

    private static Tripleton INSTANCE1;
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


    public static void main(String[] args) {
        Tripleton multiThreadedWithPerformance1 = Tripleton.getInstance();
        Tripleton multiThreadedWithPerformance2 = Tripleton.getInstance();
        Tripleton multiThreadedWithPerformance3 = Tripleton.getInstance();
        Tripleton multiThreadedWithPerformance4 = Tripleton.getInstance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance3: "+multiThreadedWithPerformance3.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance4: "+multiThreadedWithPerformance4.hashCode());

    }
}
