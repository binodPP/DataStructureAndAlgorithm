package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread;

public class ThreadExceptionHandling {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler= new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Caught exception : " + t );
            }
        };

        Thread thread= new Thread() {
            @Override
            public void run() {
                System.out.println("Sleeping ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                }
                System.out.println("Throwing exception ...");
                throw new RuntimeException();
            }

        };

        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread.start();
    }
}
