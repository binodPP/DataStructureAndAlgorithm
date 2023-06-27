package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.singletondesignpattern;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
        System.out.println("New object creation started for ThreadSafeSingleton");
    }

    //multi-threaded environment, but with low performance
    public static synchronized ThreadSafeSingleton getInstanceMultiThreaded(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton multiThreadedInstance1 = ThreadSafeSingleton.getInstanceMultiThreaded();
        ThreadSafeSingleton multiThreadedInstance2 = ThreadSafeSingleton.getInstanceMultiThreaded();

        System.out.println("Hashcode of multiThreadedInstance1: "+multiThreadedInstance1.hashCode());
        System.out.println("Hashcode of multiThreadedInstance2: "+multiThreadedInstance2.hashCode());
    }

}
