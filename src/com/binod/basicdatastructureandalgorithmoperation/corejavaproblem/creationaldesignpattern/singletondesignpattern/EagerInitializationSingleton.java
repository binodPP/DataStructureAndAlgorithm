package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class EagerInitializationSingleton {
    //Eager initialization is one of the simplest ways to create singleton.Object of
    // the class is created once class is loaded into memory.It is done by creating
    // object of the class when we declare reference variable.Even if client does
    // not need singleton object, still instance is created.If your singleton
    // object is not resource intensive, you can still use it but in general,
    // when you use singleton for connection pooling or database connections, it is resource intensive.


    //https://java2blog.com/singleton-design-pattern-java/

    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton(){
        System.out.println("New object creation started for EagerInitializationSingleton");
    }

    public static EagerInitializationSingleton getInstance(){

        return instance;
    }

    public static void main(String[] args) {
        EagerInitializationSingleton instance1= EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton instance2= EagerInitializationSingleton.getInstance();
        System.out.println("Hashcode of instance1: "+instance1.hashCode());
        System.out.println("Hashcode of instance2: "+instance2.hashCode());
    }
}
