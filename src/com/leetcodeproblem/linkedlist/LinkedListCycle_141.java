package com.leetcodeproblem.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle_141 {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        LinkedListCycle_141 findKth= new LinkedListCycle_141();
        findKth.addFirst(2);
        findKth.addFirst(3);
        findKth.addFirst(0);
        findKth.addFirst(4);

        //print(findKth.head);

        //System.out.println(hasCycle1(findKth.head));
        //System.out.println(hasCycle(findKth.head));
        //System.out.println(hasCycle3(findKth.head));



        //Below code is just for internal testing
        // insert cycle
        findKth.head.next.next.next = findKth.head;

        if (hasCycle4(findKth.head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }

    //Pattern1: TC: O(n), SC: O(1)
    //Floyd’s Cycle Detection Algorithm
    public static boolean hasCycle1(Node head) {
        if(head == null || head.next ==null){
            return false;
        }
        Node slow=head;
        Node fast= head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle4(Node head) {
        Node temp = new Node();
        while (head != null)
        {
            // This condition is for the case
            // when there is no loop
            if (head.next == null) {
                return false;
            }

            // Check if next is already
            // pointing to temp
            if (head.next == temp) {
                return true;
            }

            Node nextPoint= head.next;
            head.next=temp;
            head=nextPoint;

        }
        return false;
    }

    //Pattern2
    public static boolean hasCycle(Node head) {
        Node start= null;
        Node slow=head;
        Node fast= head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast= fast.next.next;
            if(slow == fast){
                start= head;
                while(start != slow){
                    slow= slow.next;
                    start= start.next;
                }
                return true;
            }
        }
        return false;
    }

    //Pattern3: TC: O(n), SC: O(n)
    public static boolean hasCycle3(Node head) {
        Set<Node> mp = new HashSet<>();
        while (head != null) {
            if (mp.contains(head)) {
                return true;
            }
            mp.add(head);
            head = head.next;
        }
        return false;
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
