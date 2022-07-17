package com.leetcodeproblem.linkedlist;

public class ReverseLinkedList_206 {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        MergedTwoSortedLinkedList_21 merged= new MergedTwoSortedLinkedList_21();
        merged.addFirst(30);
        merged.addFirst(25);
        merged.addFirst(15);
        merged.addFirst(6);
        merged.print(merged.head);

        //Node node=revreseLinkList(merged.head);
        //print(node);
        Node node1=revreseLinkListRecursive(merged.head);
        print(node1);
        //System.out.println("Find KTH Element is : " + findKth.findKthDataFromEndSecondMethod(findKth,3));
    }

    //iterative way, two pointer concepts
    public static Node revreseLinkList(Node head){
        Node nextPointer=null;
        Node prevPointer=null;
        while(head !=null){
            nextPointer=head.next;
            head.next=prevPointer;
            prevPointer=head;
            head=nextPointer;
        }
        return prevPointer;
    }

    //Recursive way
    public static Node revreseLinkListRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }else {
                Node nextPointer = head.next;
                head.next = null;
                Node newHead = revreseLinkListRecursive(nextPointer);
                nextPointer.next = head;
                return newHead;
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

    public static void print(Node node) {
        System.out.println("Printing the Singly LinkedList : ");
        StringBuffer str = new StringBuffer();
        while (node != null) {
            str.append(node.data).append("->");
            System.out.println(str.toString().substring(0, str.length() - 2));
            node = node.next;
        }
    }
}
