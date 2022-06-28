package com.leetcodeproblem.linkedlist;

public class RotateList_61 {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        RotateList_61 findKth= new RotateList_61();
        findKth.addFirst(5);
        findKth.addFirst(4);
        findKth.addFirst(3);
        findKth.addFirst(2);
        findKth.addFirst(1);

        int k=2;
        //print(findKth.head);

        print(rotateRight(findKth.head,k));
    }

    //Time=O(n), space=0(1)
    public static Node rotateRight(Node head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int size=0;
        Node temp=head;
        while(temp != null){
            size++;
            temp= temp.next;
        }


        k= k % size;

        if(k==0){
            return head;
        }
        Node p1= head;
        Node p2=head;
        Node newHead=null;

        for(int i=0; i <= k-1; i++){
            p2= p2.next;
        }

        while(p2.next != null){
            p1= p1.next;
            p2=p2.next;
        }

        newHead=p1.next;
        p1.next= null;
        p2.next=head;

        return newHead;

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
