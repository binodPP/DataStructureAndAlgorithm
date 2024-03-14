package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread;

public class ShutDownHookTest extends Thread{

    @Override
    public void run() {
        System.out.println("Shutdown hook task completed");
    }

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new ShutDownHookTest());

        try {
            System.out.println("ShutDown JVM using System.exit");
            System.exit(0);
        }catch (Exception exception){

        }
    }

}
