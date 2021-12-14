package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class PairwiseSwapElementsInLinkedList {

    //Input : 1->2->3->4->5->6->NULL
    //Output : 2->1->4->3->6->5->NULL

    //Input : 1->2->3->4->5->NULL
    //Output : 2->1->4->3->5->NULL

    //Input : 1->NULL
    //Output : 1->NULL

    int length=0;
    Node head=null;
    Node tail=null;
    public static void main(String[] args) {
        PairwiseSwapElementsInLinkedList pairWise= new PairwiseSwapElementsInLinkedList();
        pairWise.addFirst(6);
        pairWise.addFirst(5);
        pairWise.addFirst(4);
        pairWise.addFirst(3);
        pairWise.addFirst(2);
        pairWise.addFirst(1);
        pairWise.print();
        pairWise.swapElementsPaireWise(pairWise);
        pairWise.print();
    }

    public void swapElementsPaireWise(PairwiseSwapElementsInLinkedList l1){
        Node temp=l1.head;
        while(temp != null){
            int data= temp.data;
            temp.data=temp.next.data;
            temp.next.data=data;
            temp=temp.next.next;
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
