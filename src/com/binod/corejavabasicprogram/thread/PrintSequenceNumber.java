package com.binod.corejavabasicprogram.thread;

public class PrintSequenceNumber implements Runnable {

    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();

    PrintSequenceNumber(int remainder)
    {
        this.remainder=remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        PrintSequenceNumber runnable1=new PrintSequenceNumber(1);
        PrintSequenceNumber runnable2=new PrintSequenceNumber(2);
        PrintSequenceNumber runnable3=new PrintSequenceNumber(0);

        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");
        Thread t3=new Thread(runnable3,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
