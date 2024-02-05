package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.singletondesignpattern;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ReflectionSingletonTest {
    //using reflection we can able to to create multiple instance of singleton design pattern

    public static void main(String[] args) {
        BillPughSingleton instance1 = BillPughSingleton.getInstanceBillPughSingleton();
        BillPughSingleton instance2=null;
        try {
            Constructor<BillPughSingleton> constructor = BillPughSingleton.class.getDeclaredConstructor();
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hashcode of instance1: "+instance1.hashCode());
        System.out.println("Hashcode of instance2: "+instance2.hashCode());

    }
}
