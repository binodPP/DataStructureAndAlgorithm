package com.leetcodeproblem.linkedlist;

import java.util.Stack;

public class PalindromeLinkedList_234 {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        PalindromeLinkedList_234 findKth= new PalindromeLinkedList_234();
        findKth.addFirst(1);
        findKth.addFirst(2);
        //findKth.addFirst(3);
        findKth.addFirst(2);
        findKth.addFirst(1);


        System.out.println(isPalindrome(findKth.head));
        //System.out.println(isPalindrome1(findKth.head));
    }

    //Pattern-2: Time=O(n), space= O(1)
    public static boolean isPalindrome(Node head) {
        Node first=head;
        Node reversed=reverseList(first);
        return compareList(reversed,head);
    }

    public static boolean compareList(Node firstHalf , Node secondHalf)
    {
        while(firstHalf != null && secondHalf != null)
        {
            if(firstHalf.data != secondHalf.data){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static Node reverseList(Node head)
    {
        if(head == null || head.next == null) {
            return head;
        }

        Node reversedPart = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedPart;
    }

    //Pattern-1: Time=O(n), space= O(n)
    public static boolean isPalindrome1(Node head) {
        Stack<Integer> stack= new Stack<>();
        Node current=head;
        while(current != null){
            stack.push(current.data);
            current= current.next;
        }

        current= head;

        while(current != null && !stack.isEmpty()){

            if(current.data != stack.pop()){
                return false;
            }

            current= current.next;
        }

        return true;
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
