package com.binod.basicdatastructureandalgorithmoperation.Stack;

import java.util.Arrays;

public class StackStructureWithArray <T> {
    int size=0;
    int array[] = new int[6];


    //int index=0;

    private void push(int data){
        if(array.length == getSize()){
            int newLength =  size== 0 ? 6 : size*2;
            array= Arrays.copyOf(array,newLength);
            System.out.println("After copied New array length is : " + array.length);
        }
        array[size++]=data;
        System.out.println("Pushed element:" + data);
    }

    private int pop(){
           if(getSize() == 0){
               System.out.println("Stack is empty");
               return -1;
           }else{
               System.out.println("Popped element :" + array[--size]);
               return array[size];
           }
    }

    private int peek(){
        if(getSize() == 0){
            System.out.println("Stack is empty");
            return -1;
        }else{
            System.out.println("Peeked element in stack is :" + array[size-1]);
            return array[size-1];
        }
    }

    private int getSize(){
        return size;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(array[i]);
            if(i < size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        System.out.println("Array length is:" + array.length);
        return sb.toString();
    }

    public static void main(String[] args) {
        StackStructureWithArray<Integer> StackCustom = new StackStructureWithArray();
        System.out.println("=================");
        StackCustom.push(10);
        StackCustom.push(30);
        StackCustom.push(50);
        StackCustom.push(40);
        System.out.println("Pushed element in the array:" + StackCustom.toString());
        System.out.println("=================");
        System.out.println("Peeked element from the array is :" + StackCustom.peek());
        System.out.println("=================");
        StackCustom.pop();
        StackCustom.pop();
        StackCustom.pop();
        System.out.println("After Popped remaining element in the array:" + StackCustom);
        System.out.println("=================");
        System.out.println("Peeked element from the array is :" + StackCustom.peek());
        System.out.println("=================");
    }
}