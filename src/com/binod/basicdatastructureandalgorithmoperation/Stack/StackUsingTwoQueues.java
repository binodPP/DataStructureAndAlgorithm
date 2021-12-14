package com.binod.basicdatastructureandalgorithmoperation.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StackUsingTwoQueues {
    private static String StackUsingTwoQueues;
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(20);
        stack.push(40);
        stack.push(70);
        stack.push(50);
        stack.push(90);
        stack.push(110);
        stack.push(30);

        System.out.println("Removed element : " + stack.pop());
        System.out.println("Removed element : " + stack.pop());
        System.out.println("Removed element : " + stack.pop());
        System.out.println("Peeked element : " + stack.peek());
        stack.push(170);
        System.out.println("peeked element : " + stack.peek());
        System.out.println("Removed element : " + stack.pop());
    }

    public void push(int i) {
        if (queue1.size() == 0) {
            queue1.add(i);
        } else {
            int newSize = queue1.size();
            for (int j = 0; j < newSize; j++)
                queue2.add(queue1.remove());
            queue1.add(i);
            for (int k = 0; k < newSize; k++) {
                queue1.add(queue2.remove());
            }
        }
    }

    public int pop() {
        if (queue1.size() == 0) {
            throw new SecurityException("Queue is empty");
        }

        return queue1.remove();

    }

    public int peek() {
        if (queue1.size() == 0) {
            throw new SecurityException("Queue is empty nothing to peek");
        }
        return queue1.peek();
    }
}


