package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class AddTwoNumbers {

    //https://leetcode.com/problems/add-two-numbers/

    int length=0;
    Node head;
    Node tail;

    public static void main(String[] args) {
        AddTwoNumbers linkedList = new AddTwoNumbers();
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(2);
        linkedList.print();

        AddTwoNumbers linkedList1 = new AddTwoNumbers();
        linkedList1.addFirst(4);
        linkedList1.addFirst(6);
        linkedList1.addFirst(5);
        linkedList1.print();

        Node node= new AddTwoNumbers().addTwoNumbersLinkList(linkedList.head,linkedList1.head);
        print(node);
    }

    public  Node addTwoNumbersLinkList(Node node1, Node node2) {
        Node l1 = revreseLinkList1(node1);
        Node l2 = revreseLinkList1(node2);
        int sum = 0;
        int carry = 0;
        Node finalNode = null;
        //Node current = null;
        Node temp=null;
        while (l1 != null || l2 != null) {
            sum = carry + (l1 !=null?l1.data:0) + (l2 !=null?l2.data:0);
                carry = sum / 10;
            sum = sum % 10;
            temp = new Node(sum);
            if (finalNode == null) {
                finalNode = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry >0){
            temp.next=new Node(carry);
        }
        return finalNode;
    }


    public static Node revreseLinkList1(Node node){
        Node nextPointer=null;
        Node prevPointer=null;
        while(node !=null){
            nextPointer=node.next;
            node.next=prevPointer;
            prevPointer=node;
            node=nextPointer;
        }
        return prevPointer;
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
