package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class DeleteLastOccurrence {
    int length=0;
    Node head;
    Node tail;
    public static void main(String[] args) {
        DeleteLastOccurrence lastOccurrence= new DeleteLastOccurrence();
        lastOccurrence.addFirst(6);
        lastOccurrence.addFirst(5);
        lastOccurrence.addFirst(4);
        lastOccurrence.addFirst(3);
        lastOccurrence.addFirst(2);
        lastOccurrence.addFirst(1);
        lastOccurrence.print();
        lastOccurrence.deleteLast(lastOccurrence.head, 3);
        lastOccurrence.print();

    }

    //Generic code to delete node from first, last, and from any position in te linked list
    public void deleteLast(Node node,int key){
        Node prev=node;
        Node current=node.next;

        if(prev.data==key){
            head=current;
            //prev=null;
        }else {
            while (current.data != key) {
                prev = prev.next;
                current = current.next;
            }
        }

         if(current.next == null){
            System.out.println(current.data);
            prev.next=null;
        }else {
            prev.next=current.next;
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

    public void print(Node node) {
        System.out.println("Printing the Singly LinkedList : ");
        StringBuffer str = new StringBuffer();
        while (node != null) {
            str.append(node.data).append("->");
            System.out.println(str.toString().substring(0, str.length() - 2));
            node = node.next;
        }
    }
}
