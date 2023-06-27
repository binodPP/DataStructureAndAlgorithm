package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.singletondesignpattern;

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
