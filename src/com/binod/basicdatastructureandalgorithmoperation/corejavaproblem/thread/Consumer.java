package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread;

import java.util.Queue;

class Consumer extends Thread {
    private Queue<Integer> queue;
    public Consumer(Queue<Integer> queue, String name){
        super(name);
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notify();
            }
        }
    }
}

