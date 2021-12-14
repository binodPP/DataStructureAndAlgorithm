package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class DoublyLinkList {
    int size=0;
    Node head=null;
    Node tail=null;

    private Node addAtFirstInDoublyLinkList(int data){
        System.out.println("Adding Node " + data + " at the start");
        Node node= new Node(data);
         if(getSize() == 0){
             head=node;
             tail=node;
         }else{
             node.next=head;
             head.prev=node;
             head=node;
             head.prev=null;
         }
         size++;
         return node;
    }

    private Node addAtLastInDoublyLinkList(int data){
        System.out.println("Adding Node " + data + " at the Last");
        Node node = new Node(data);
        if(getSize() == 0){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
        return node;
    }

    private void removeFromFirstInDoublyLinkList(){
        System.out.println("Removing Node from the start");
        if(getSize() == 0){
            System.out.println("\nNode is Empty");
        }else if(getSize() == 1){
            head=null;
            tail=null;
            System.out.println("\nNode is going to be empty and head is pointed to : " + head +"\nand tail is pointed to :" + tail );
            size--;
        }else{
            System.out.println("\ndeleting node " + head.data + " from start");
            head.prev=null;
            head=head.next;
            size--;
        }
    }

    private void removeFromLastInDoublyLinkList(){
        System.out.println("Removing Node from the Last");
        Node temp1=head;
        if(getSize() == 0){
            System.out.println("\nNode is Empty");
        }else if(getSize() == 1){
            head=null;
            tail=null;
            System.out.println("\nNode is going to be empty and head is pointed to : " + head +"\nand tail is pointed to :" + tail );
            size--;
        } else{
            tail.prev.next=null;
            tail=tail.prev;
            size--;
        }
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
                current=temp4.next.prev;
                temp4=null;
            }
            size--;
        }
    }

    private int getSize(){
        return size;
    }

    public void print(){
        Node temp = head;
        System.out.println("Doubly Link List are : ");
        while(temp != null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        Node x= doublyLinkList.addAtFirstInDoublyLinkList(4);
        doublyLinkList.addAtFirstInDoublyLinkList(3);
        doublyLinkList.addAtFirstInDoublyLinkList(7);
        doublyLinkList.print();
        doublyLinkList.addAtLastInDoublyLinkList(8);
        doublyLinkList.print();
        doublyLinkList.removeFromFirstInDoublyLinkList();
        doublyLinkList.print();
        doublyLinkList.removeFromLastInDoublyLinkList();
        doublyLinkList.print();
        System.out.println("Element at index 2: "+doublyLinkList.findElemnetAtIndex(2));
        System.out.println("Size of the Node : "+doublyLinkList.getSize());
        Node y=doublyLinkList.addElementAtMiddle(9);
        System.out.println( "Updated List: added node 9 at middle ");
        doublyLinkList.print();
        Node x1=doublyLinkList.addElementAtSpecifiedIndex(10,3);
        System.out.println( "Updated List: added node 10 at given index 3 ");
        doublyLinkList.print();
        doublyLinkList.removedElementAtSpecifiedIndex(3);
        System.out.println( "Updated List: removed node 4 at given index 3 ");
        doublyLinkList.print();
    }
}