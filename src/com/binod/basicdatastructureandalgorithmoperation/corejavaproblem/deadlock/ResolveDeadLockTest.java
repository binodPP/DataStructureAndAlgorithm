package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.deadlock;

import javax.jws.soap.SOAPBinding;

public class ResolveDeadLockTest {
   private static final Object LOCK1= new Object();
    private static final Object LOCK2= new Object();
    public static void main(String[] args) {

         //Created deadlock
        // Thread-1
        Runnable block1 = () -> {
            synchronized (LOCK1) {
                System.out.println("Thread 1 holding a Lock1");
                try {
                    // Adding delay so that both threads can start trying to
                    // lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-1
                System.out.println("Thread 1 waiting for a Lock2");
                synchronized (LOCK2) {
                    System.out.println("Thread 1 holding a Lock1 and Lock2");
                }
            }
        };

        // Thread-2
        Runnable block2 = () -> {
            synchronized (LOCK2) {
                System.out.println("Thread 2 holding a Lock2");
                try {
                    // Adding delay so that both threads can start trying to
                    // lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-2
                System.out.println("Thread 2 waiting for a Lock1");
                synchronized (LOCK1) {
                    System.out.println("Thread 2 holding a Lock1 and Lock2");
                }
            }
        };

        /*Resolve deadlock : To solve the deadlock problem in the given example,
        you need to ensure that threads acquire locks in a consistent order. One common
         approach to avoid deadlock is to make sure that
        all threads acquire locks in the same order.
        // Thread-1

        Runnable block2 = () -> {
            synchronized (LOCK1) {
                System.out.println("Thread 2 holding a Lock1");
                try {
                    // Adding delay so that both threads can start trying to
                    // lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-2
                System.out.println("Thread 2 waiting for a Lock2");
                synchronized (LOCK1) {
                    System.out.println("Thread 2 holding a Lock1 and Lock2");
                }
            }
        };*/

        new Thread(block1).start();
        new Thread(block2).start();
    }
}
