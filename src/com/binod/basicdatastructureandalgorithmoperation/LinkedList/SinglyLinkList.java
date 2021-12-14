
package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class SinglyLinkList {
    int size=0;
    Node head=null;
    Node tail=null;
    private Node addAtFirst(int data){
        System.out.println("Adding Node " + data + " at the start");
        Node node = new Node(data);
        if(size == 0){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head=node;
        }
        size++;
        return node;
    }

    private Node addAtLast(int data){
        System.out.println("Adding Node " + data + " at the Last");
        Node node = new Node(data);
        if(size == 0){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        size++;
        return node;
    }

    private void removeFromFirst(){
        System.out.println("Removing Node from the start");
        if(size == 0){
            System.out.println("\nNode is Empty");
        }else if(size == 1){
            head=null;
            tail=null;
            System.out.println("\nNode is going to be empty and head is pointed to : " + head +"\nand tail is pointed to :" + tail );
        }else{
            head=head.next;
        }
        size--;
    }

    private void removeFromLast(){
        System.out.println("Removing Node from the Last");
        Node temp1=head;
        if(size == 0){
            System.out.println("\nNode is Empty");
        }else if(size == 1){
            head=null;
            tail=null;
            System.out.println("\nNode is going to be empty and head is pointed to : " + head +"\nand tail is pointed to :" + tail );
        } else{
            while(temp1.next != tail){
                temp1=temp1.next;
            }
            temp1.next=null;
            tail=temp1;
        }
        size--;
    }

    private int findElemnetAtIndex(int index){
        if(index > size){
            return -1;
        }else {
            Node temp3=head;
            while(index-1 != 0 ){
                temp3=temp3.next;
                index --;
            }
            return temp3.data;
        }
    }

    private int getNodeSize(){
        return size;
    }

    private Node addElementAtMiddle(int data){
        Node node3=new Node(data);
        if(size==0){
            head=node3;
            tail=node3;
        }else {
            Node temp4, current;
            temp4 = head;
            current = null;
            int count = (size % 2 == 0) ? size / 2 : ((size + 1) / 2);
            for (int i = 0; i < count; i++) {
                current = temp4;
                temp4 = temp4.next;
            }
            current.next=node3;
            node3.next=temp4;
            size++;
        }
        return node3;
    }

    private Node addElementAtSpecifiedIndex(int data, int index){
        Node node4=new Node(data);
        if(index > size){
            System.out.println("Invalid index ");
        }else {
            Node temp4, current;
            temp4=head;
            current=null;
            for(int i=0; i<index; i++){
               current=temp4;
               temp4=temp4.next;
            }
            current.next=node4;
            node4.next=temp4;
            size++;
        }
            return node4;
    }

    private void removedElementAtSpecifiedIndex(int index){
        if(index > size){
            System.out.println("Invalid index ");
        }else if(index == size){
            head=tail=null;
        }else {
            Node temp4, current;
            temp4=head;
            current=null;
            for(int i=0; i<index-1; i++){
                current=temp4;
                temp4=temp4.next;
            }
            if(current !=null){
                current.next=temp4.next;
                temp4=null;
            }
            size--;
        }
    }

    public void print(){
        Node temp = head;
        System.out.print("Singly Linked List: ");
        while(temp!=null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        Node x= singlyLinkList.addAtFirst(4);
        singlyLinkList.addAtFirst(3);
        singlyLinkList.addAtFirst(7);
        singlyLinkList.print();
        singlyLinkList.addAtLast(8);
        singlyLinkList.print();
        singlyLinkList.removeFromFirst();
        singlyLinkList.print();
        singlyLinkList.removeFromLast();
        singlyLinkList.print();
        System.out.println("Element at index 2: "+singlyLinkList.findElemnetAtIndex(2));
        System.out.println("Size of the Node : "+singlyLinkList.getNodeSize());
        Node y=singlyLinkList.addElementAtMiddle(9);
        System.out.println( "Updated List: added node 9 at middle ");
        singlyLinkList.print();
        Node x1=singlyLinkList.addElementAtSpecifiedIndex(10,3);
        System.out.println( "Updated List: added node 10 at given index 3 ");
        singlyLinkList.print();
        singlyLinkList.removedElementAtSpecifiedIndex(3);
        System.out.println( "Updated List: removed node 9 at given index 3 ");
        singlyLinkList.print();
        //singlyLinkList.print();
        //System.out.println("Size of the Linked List: " + ;
    }
}
