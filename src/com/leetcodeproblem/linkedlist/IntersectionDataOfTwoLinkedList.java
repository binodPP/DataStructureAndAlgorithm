package com.leetcodeproblem.linkedlist;

public class IntersectionDataOfTwoLinkedList {
    int length=0;
    Node head;
    Node tail;

    public static void main(String[] args) {
        IntersectionDataOfTwoLinkedList intersection= new IntersectionDataOfTwoLinkedList();
        intersection.addFirst(30);
        intersection.addFirst(15);
        intersection.addFirst(7);
        intersection.addFirst(6);
        intersection.addFirst(3);
        intersection.addFirst(2);
        intersection.addFirst(1);
        intersection.print();

        IntersectionDataOfTwoLinkedList intersection1= new IntersectionDataOfTwoLinkedList();

        intersection1.addFirst(30);
        intersection1.addFirst(15);
        intersection1.addFirst(10);
        intersection1.addFirst(9);
        intersection1.addFirst(8);

        intersection1.print();
        System.out.println(getIntersection(intersection.head,intersection1.head));

    }

    public static int getIntersection(Node l1, Node l2){
          int l1Length=0;
          int l2Length=0;
          Node l1Temp=l1;
          //first find the length of both the list
          while(l1Temp != null){
              l1Temp=l1Temp.next;
              l1Length++;
          }

        Node l2Temp=l2;
        while(l2Temp != null){
            l2Temp=l2Temp.next;
            l2Length++;
        }

        //calculate the difference and traverse the longest list till the diff count
        int diffLength=0;
        Node currentL1=l1;
        Node currentL2=l2;
        if(l1Length >= l2Length){
            diffLength=l1Length-l2Length;
            for(int i=1; i <= diffLength;i++){
                currentL1=currentL1.next;
            }
        }else {
            diffLength=l2Length-l1Length;
            for(int i=1; i <= diffLength;i++){
                currentL2=currentL2.next;
            }
        }

        //now start both the list one by one to traverse
        while(currentL1 != null && currentL2 != null){
            if(currentL1.data == currentL2.data){
                return currentL1.data;
            }
            currentL1=currentL1.next;
            currentL2=currentL2.next;
        }

       return -1;
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
