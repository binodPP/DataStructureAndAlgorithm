package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

import java.io.Serializable;

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
        return new CloneNotSupportedException();
    }

    public static void main(String[] args) {
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance1 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance2 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());

    }
}
