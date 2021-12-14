package com.binod.basicdatastructureandalgorithmoperation.Stack;

public class StackStructureWithLinkList {
    int size;
    Node head=null;
    private Node push(int data){
        Node node = new Node(data);
        if(getSizeStack() == 0){
            head=node;
        }else{
            //Node temp=head;
            node.next=head;
            head=node;
        }
        System.out.println("Element "+ data + " is pushed into Stack");
        size++;
        return node;
    }

    private int peek(){
          if(getSizeStack() ==0){
              System.out.println("Stack is EMPTY");
              return -1;
          }else{
              System.out.println("\nStack top element is : " + head.data);
              return head.data;
          }
    }

    private int pop(){
        Node temp1=head;
        if(getSizeStack() == 0){
            System.out.println("\nStack is EMPTY not need to pop");
            return -1;
        }else{
            head=head.next;
            size--;
            return temp1.data;
        }
    }

    private int getSizeStack(){
        return size;
    }

    private void printStack(){
        Node current=head;
        while(current !=null){
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StackStructureWithLinkList stack = new StackStructureWithLinkList();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.printStack();
        System.out.printf("Peek the element from stack : " + stack.peek());
        System.out.println("\nPop out element " + stack.pop());
        stack.printStack();
    }
}