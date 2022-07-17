package com.leetcodeproblem.linkedlist;

import java.util.Stack;

public class AddTwoNumbers_445 {

    //https://leetcode.com/problems/add-two-numbers/

    int length=0;
    Node head;
    Node tail;

    public static void main(String[] args) {
        AddTwoNumbers_445 linkedList = new AddTwoNumbers_445();
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(2);
        linkedList.addFirst(7);

        linkedList.print();

        AddTwoNumbers_445 linkedList1 = new AddTwoNumbers_445();
        linkedList1.addFirst(4);
        linkedList1.addFirst(6);
        linkedList1.addFirst(5);



        linkedList1.print();

        Node node= new AddTwoNumbers_445().addTwoNumbers(linkedList.head,linkedList1.head);
        Node node1= new AddTwoNumbers_445().addTwoNumbersLinkList(linkedList.head,linkedList1.head);
        print(node);
        print(node1);
    }

    //Pattern 1: without reversing the linked list
    //Time Complexity: O(n)). Assume that m and n represent the
    // length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.

    //Space Complexity: O(n))
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Stack<Integer> stack1= new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1.data);
            l1= l1.next;
        }

        while(l2 != null){
            stack2.push(l2.data);
            l2= l2.next;
        }

        Node temp=null;
        while( !stack1.isEmpty() || !stack2.isEmpty() || carry >0) {
            int sum = 0;
            sum = carry + (stack1.isEmpty()?0:stack1.pop()) + (stack2.isEmpty()?0:stack2.pop());
            carry = sum / 10;
            sum= sum% 10;
            Node node = new Node(sum);
            node.next = temp;
            temp = node;
        }
        return temp;
    }

    //Pattern 2: by reversing the linked list
    public Node addTwoNumbersLinkList(Node node1, Node node2) {
        Node l1 = revreseLinkList1(node1);
        Node l2 = revreseLinkList1(node2);
        int sum = 0;
        int carry = 0;
        Node temp = null;
        while (l1 != null || l2 != null || carry >0) {
            sum = carry + (l1 !=null?l1.data:0) + (l2 !=null?l2.data:0);
                carry = sum / 10;
            sum = sum % 10;
            Node node = new Node(sum);
            node.next=temp;
            temp=node;
            /*if (finalNode == null) {
                finalNode = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }*/

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
       /* if(carry >0){
            temp.next=new Node(carry);
        }*/
        return temp;
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
