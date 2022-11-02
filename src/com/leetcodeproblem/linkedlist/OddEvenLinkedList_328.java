package com.leetcodeproblem.linkedlist;

public class OddEvenLinkedList_328 {

    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        OddEvenLinkedList_328 findKth= new OddEvenLinkedList_328();
        findKth.addFirst(8);
        findKth.addFirst(7);
        findKth.addFirst(6);
        findKth.addFirst(5);
        findKth.addFirst(4);
        findKth.addFirst(3);
        findKth.addFirst(2);
        findKth.addFirst(1);

        //print(findKth.head);

        print(oddEvenList(findKth.head));
    }

    //TimeComplexity= O(n), space= O(1)
    public static Node oddEvenList(Node head) {

        if(head == null){
            return null;
        }
        Node odd=head;
        Node even= head.next;
        Node evenHead= head.next;

        while(even != null && even.next != null){
            odd.next= odd.next.next;
            odd= odd.next;
            even.next= even.next.next;
            even=even.next;
        }

        odd.next=evenHead;

        return head;

    }
    public void addFirst(int data){
        Node nodeData= new Node(data);
        if(length ==0){
            System.out.println("LinkedList is empty, adding the data in it");
            head=nodeData;
            //tail=nodeData;
            length++;
        }else{
            nodeData.next=head;
            head=nodeData;
            length++;
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
