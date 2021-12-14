package com.binod.basicdatastructureandalgorithmoperation.Stack;

public class SortStackUsingAnotherStack {

    int arr[];
    int size=0;
    int top;
    public SortStackUsingAnotherStack(int totalSize){
        this.arr= new int[totalSize];
        this.size=totalSize;
        this.top=-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }


    public void push(int pushedElement){
              if(arr.length-1 == top){
                  System.out.println("Stack is full");
              }else{
                  top++;
                  arr[top]=pushedElement;
              }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            int poppedElemnet=arr[top];
            top--;
            System.out.println("Popped Element : " + poppedElemnet);
            return poppedElemnet;
        }
    }

    public void printStack(SortStackUsingAnotherStack stack) {
        if (top >= 0) {
            System.out.println("Elements of stacks are:");
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public int peek(){
        if(top != -1){
            System.out.println("Stack is Empty");
        }
        return arr[top];
    }

    public SortStackUsingAnotherStack sortStack(SortStackUsingAnotherStack stack1, int secondStachSize){
        SortStackUsingAnotherStack stack2= new SortStackUsingAnotherStack(secondStachSize);
        while(!stack1.isEmpty()){
            int currentData=stack1.pop();
            while(!stack2.isEmpty() && stack2.peek() > currentData){
               stack1.push(stack2.pop());
            }
            stack2.push(currentData);
        }

        return stack2;
    }

    public static void main(String[] args) {
        SortStackUsingAnotherStack stackCustom = new SortStackUsingAnotherStack(10);
        SortStackUsingAnotherStack stackCustom1 = new SortStackUsingAnotherStack(10);

        System.out.println("=================");
        stackCustom.push(10);
        stackCustom.push(30);
        stackCustom.push(50);
        stackCustom.push(40);
        stackCustom.printStack(stackCustom);
        //stackCustom.pop();
        SortStackUsingAnotherStack sortedStack=stackCustom1.sortStack(stackCustom,10);
        System.out.println("=================");
        System.out.println("After Sorting :");
        System.out.println("=================");
        sortedStack.printStack(sortedStack);

    }
}
