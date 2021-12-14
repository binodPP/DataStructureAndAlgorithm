package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class SortTheLinkedList {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        SortTheLinkedList linkedList= new SortTheLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(5);
        linkedList.addFirst(2);
        linkedList.addFirst(6);
        linkedList.print();
        sort(linkedList);
        linkedList.print();
    }

    //Method 1, using bubble sort
    public static void sort(SortTheLinkedList sortTheLinkedList){
        Node first=sortTheLinkedList.head;
        Node second= null;
        while(first !=null){
            second=first.next;
            while (second !=null){
                if(first.data > second.data){
                    int data=second.data;
                    second.data=first.data;
                    first.data=data;

                }
                second=second.next;
            }
            first=first.next;
        }
    }

    public void addFirst(int data){
        Node nodeData= new Node(data);
        if(length ==0){
            System.out.println("LinkedList is empty, adding the data in it");
            head=nodeData;
            tail=nodeData;
            length++;
        }else{
            nodeData.next=head;
            head=nodeData;
            length++;
        }
    }

    public void print() {
        System.out.println("Printing the Singly LinkedList : ");
        Node temp = head;
        StringBuffer str = new StringBuffer();
        while (temp != null) {
            str.append(temp.data).append("->");
            System.out.println(str.toString().substring(0, str.length() - 2));
            temp = temp.next;
        }
    }
}
