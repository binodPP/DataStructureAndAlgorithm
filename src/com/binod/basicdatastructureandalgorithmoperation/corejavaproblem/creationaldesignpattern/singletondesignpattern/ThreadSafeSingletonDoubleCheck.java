package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

public class ThreadSafeSingletonDoubleCheck {
    //use below code for double check locking
    private static volatile ThreadSafeSingletonDoubleCheck instanceDoubleCheckLocking;

    private ThreadSafeSingletonDoubleCheck(){
        System.out.println("New object creation started for ThreadSafeSingletonDoubleCheck");
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

    public static void main(String[] args) {
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance1 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();
        ThreadSafeSingletonDoubleCheck multiThreadedWithPerformance2 = ThreadSafeSingletonDoubleCheck.getInstanceMultiThreadedWithPerformance();

        System.out.println("Hashcode of multiThreadedWithPerformance1: "+multiThreadedWithPerformance1.hashCode());
        System.out.println("Hashcode of multiThreadedWithPerformance2: "+multiThreadedWithPerformance2.hashCode());

    }
}
