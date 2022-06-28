package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class LazyInitializationSingleton {
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton(){
        System.out.println("New object creation started for LazyInitializationSingleton");
    }

    //single-threaded environment , in case of multithreaded environment it might create multiple object instance.
    public static LazyInitializationSingleton getInstanceSingleThreadedEnvironment(){
        if(instance == null){
            instance = new LazyInitializationSingleton();
        }

        return instance;
    }


    public static void main(String[] args) {
        LazyInitializationSingleton singleThreadedInstance1 = LazyInitializationSingleton.getInstanceSingleThreadedEnvironment();
        LazyInitializationSingleton singleThreadedInstance2 = LazyInitializationSingleton.getInstanceSingleThreadedEnvironment();

        System.out.println("Hashcode of singleThreadedInstance1: "+singleThreadedInstance1.hashCode());
        System.out.println("Hashcode of singleThreadedInstance2: "+singleThreadedInstance2.hashCode());

    }

}
