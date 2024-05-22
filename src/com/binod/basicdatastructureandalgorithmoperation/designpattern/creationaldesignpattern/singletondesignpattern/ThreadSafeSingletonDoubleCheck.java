package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.singletondesignpattern;

import java.io.Serializable;

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
public class ThreadSafeSingletonDoubleCheck implements Cloneable, Serializable {
    //use below code for double check locking
    private static volatile ThreadSafeSingletonDoubleCheck instanceDoubleCheckLocking;

    private ThreadSafeSingletonDoubleCheck(){
        if(instanceDoubleCheckLocking!=null)
        {
            throw new RuntimeException("You can not create object of singleton class twice");
        }
    }

    //multi-threaded environment  with better performance, using double check locking
    public static ThreadSafeSingletonDoubleCheck getInstanceMultiThreadedWithPerformance(){
        if(instanceDoubleCheckLocking == null){
            synchronized (ThreadSafeSingletonDoubleCheck.class){
                if(instanceDoubleCheckLocking == null){
                    instanceDoubleCheckLocking = new ThreadSafeSingletonDoubleCheck();
                }
            }
        }

        return instanceDoubleCheckLocking;
    }

    // to restrict not to create multiple instance using serialization , need to use below method
    protected Object readResolve() {
        return instanceDoubleCheckLocking;
    }

    // to restrict not to create multiple instance using clone, need to use below code
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        return new CloneNotSupportedException();
    }



    public static void main(String[] args) {
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance1 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance2 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());

    }
}
