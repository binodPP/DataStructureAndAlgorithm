package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

import java.util.Spliterator;

public class FindMiddleElementLinkedList {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        FindMiddleElementLinkedList findMiddleData1= new FindMiddleElementLinkedList();
        findMiddleData1.addFirst(1);
        findMiddleData1.addFirst(4);
        findMiddleData1.addFirst(5);
        findMiddleData1.addFirst(6);
        findMiddleData1.print();
        System.out.println("Middle Element is : " + findMiddleData1.findMiddleDataFirstMethod(findMiddleData1));
        System.out.println("Middle Element is : " + findMiddleData1.findMiddleDataSecondMethod(findMiddleData1));
    }

    //Method 1 using full traverse to find first count then find the mid node
    public int findMiddleDataFirstMethod(FindMiddleElementLinkedList findMiddleElementLinkedList){
        int count=0;
        //to find the count of nodes in liked list
        Node temp=findMiddleElementLinkedList.head;
        while(temp !=null){
            temp=temp.next;
            count++;
        }

        System.out.println("Count : " +count);
        //to find the middle node of linked list
        int midIndex=count%2==0?(count/2):(count+1)/2;
            Node middle=findMiddleElementLinkedList.head;
        System.out.println("Mid Index : " +midIndex);
            for(int i=0; i < midIndex; i++){
               middle=middle.next;
            }
        return middle.data;
    }

    //Method 2 using two pointer, move one pointer with next node and
    // other pointer with two node and once 2nd pointer reached at the end then return first pointer data
    public int findMiddleDataSecondMethod(FindMiddleElementLinkedList findMiddleElementLinkedList) {

        Node firstPointer= findMiddleElementLinkedList.head;
        Node secondPointer= findMiddleElementLinkedList.head;
        if(head !=null){
            while(secondPointer !=null && secondPointer.next !=null){
                secondPointer= secondPointer.next.next;
                firstPointer=firstPointer.next;
            }
        }
        return firstPointer.data;
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
