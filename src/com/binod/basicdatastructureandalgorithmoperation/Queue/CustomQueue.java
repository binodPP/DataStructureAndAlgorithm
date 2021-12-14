package com.binod.basicdatastructureandalgorithmoperation.Queue;

public class CustomQueue {
    int size=0;
    int head=0;
    int tail=-1;
    int array[] = new int[0];

    private void enqueue(int item){
        if(isQueueFull()){
            System.out.println("Queue is full!! need to grow array to add more elements");
            int newLength = size == 0 ? 4 : size*2;
            int arrayNew[] = new int [newLength];
            if(getSize() > 0){
                int index=0;
                if(tail < head){
                     for(int i=head ; i < array.length ; i++){
                         arrayNew[index] = array[i];
                         index++;
                     }

                     for(int i=0 ; i< head-1 ; i++){
                         arrayNew[index]=array[i];
                         index++;
                     }
                }else{
                    for(int i=head ; i<=tail ; i++){
                        arrayNew[index]=array[i];
                        index++;
                    }
                }
                head=0;
                tail=index-1;
            }else {
                head=0;
                tail=-1;
            }
            array=arrayNew;
        }

        if(tail==array.length-1){
            tail=0;
        }else{
            tail++;
        }
        array[tail]=item;
        size++;
        System.out.println(array[tail] + " added to the queue");
    }

    private int dequeue(){
        if(isQueueEmpty()){
            System.out.println("Queue is empty!! Can not dequeue element");
        }

        int value = array[head];
        if(head == array.length-1){
            head=0;
        }else {
            head++;
        }
        size--;
        System.out.println(value + " dequeue from the queue");
        return value;
    }

    private int getSize(){
        return size;
    }

    private int peek(){
        int peekValue=0;
        if(!isQueueEmpty()){
            peekValue=array[head];
            return peekValue;
        }
        return peekValue;
    }

    private boolean isQueueFull(){
        if(getSize() == array.length){
            return true;
        }
        return false;
    }

    private boolean isQueueEmpty(){
        if(getSize()==0){
            return true;
        }
        return false;
    }

    public static void main(String a[]) {

        CustomQueue queue = new CustomQueue();
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(99);
        queue.enqueue(56);
        queue.dequeue();
        queue.enqueue(43);
        queue.dequeue();
        queue.enqueue(89);
        queue.enqueue(77);
        queue.dequeue();
        queue.enqueue(32);
        queue.enqueue(232);
    }

}