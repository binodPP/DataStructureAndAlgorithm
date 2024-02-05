package com.leetcodeproblem.linkedlist;

import java.util.Stack;

public class AddTwoNumbers_445 {

    //https://leetcode.com/problems/add-two-numbers/

    int length=0;
    Node head;
    Node tail;

   /* public static void main(String[] args) {
        Node node = new Node(3);
        node.next= new Node(4);
        node.next.next = new Node(2);

        print(node);

        Node node1 = new Node(4);
        node1.next = new Node(6);
        node1.next.next = new Node(5);

        print(node1);

        Node node2= new AddTwoNumbers_445().addTwoNumbers(node,node1);
        Node node3= new AddTwoNumbers_445().addTwoNumbersLinkList(node,node1);

        Node node4= new AddTwoNumbers_445().addTwoNumbers_1(node,node1);
        print(node2);
        print(node3);
        print(node4);
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
        Node current = null;
        while( !stack1.isEmpty() || !stack2.isEmpty() || carry >0) {
            int sum = 0;
            sum = carry + (stack1.isEmpty()?0:stack1.pop()) + (stack2.isEmpty()?0:stack2.pop());
            carry = sum / 10;
            sum= sum% 10;
            Node node = new Node(sum);
            if(current == null) {
                current = node;
                temp = current;
            }else {
                temp.next = node;
                temp = temp.next;
            }
        }
        return current;
    }

    //Pattern 2: by reversing the linked list
    public Node addTwoNumbersLinkList(Node l1, Node l2) {
         l1 = revreseLinkList1(l1);
         l2 = revreseLinkList1(l2);
        int carry = 0;
        Node temp = null;
        Node current = null;
        while (l1 != null || l2 != null || carry >0) {
            int sum = carry + (l1 !=null?l1.data:0) + (l2 !=null?l2.data:0);
                carry = sum / 10;
            sum = sum % 10;
            Node node = new Node(sum);
            if(current == null) {
                current = node;
                temp = current;
            }else {
                temp.next = node;
                temp = temp.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return current;
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
    }*/


    public Node addTwoNumbers_1(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry >0) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new Node(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers_445 solution = new AddTwoNumbers_445();

        // Example usage:
        int[] arr1 = {9, 4, 3}; // Represents the number 342
        int[] arr2 = {5, 6, 4}; // Represents the number 465

        Node l1 = solution.createLinkedList(arr1);
        Node l2 = solution.createLinkedList(arr2);

        System.out.println("Input Linked Lists:");
        solution.printLinkedList(l1);
        solution.printLinkedList(l2);

        Node result = solution.addTwoNumbers_1(l1, l2);

        System.out.println("Sum Linked List:");
        solution.printLinkedList(result);
    }

    // Helper method to create a linked list from an array of integers
    private Node createLinkedList(int[] nums) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;

        for (int num : nums) {
            current.next = new Node(num);
            current = current.next;
        }

        return dummyHead.next;
    }

    // Helper method to print the linked list
    private void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
