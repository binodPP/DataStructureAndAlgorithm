package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread;

public class PrintOddEvenNumber{
    private int counter=1;
    private int N=10;

    public static void main(String[] args)
    {
        // Given Number N
       /* N = 10;*/

        // Create an object of class
        PrintOddEvenNumber mt = new PrintOddEvenNumber();

        // Create thread t1
        Thread t1 = new Thread(() -> mt.printEvenNumber());

        // Create thread t2
        Thread t2 = new Thread(() -> mt.printOddNumber());

        // Start both threads
        t1.start();
        t2.start();
    }

    public void printOddNumber()
    {
            // Print number till the N
            while (counter < N) {
                synchronized (this)
                {
                // If count is even then print
                while (counter % 2 == 0) {

                    // Exception handle
                    try {
                        wait(100);
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.print(counter + " ");

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    public void printEvenNumber()
    {

            // Print number till the N
            while (counter < N) {
                synchronized (this)
                {
                // If count is odd then print
                while (counter % 2 == 1) {

                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.print(
                        counter + " ");

                // Increment counter
                counter++;

                // Notify to 2nd thread
                notify();
            }
        }
    }
}
