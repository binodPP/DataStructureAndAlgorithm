package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerInJava {

    public static void main(String args[]) {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumer Problem");
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Producer producer = new Producer(buffer, maxSize, "PRODUCER");
        Consumer consumer = new Consumer(buffer, "CONSUMER");

        producer.start();
        consumer.start(); }

}
