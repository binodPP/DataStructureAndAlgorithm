package com.leetcodeproblem.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle_141 {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        LinkedListCycle_141 cycleStartFinder = new LinkedListCycle_141();
        Boolean cycleStartNode = cycleStartFinder.hasCycle(head);
        if (Boolean.TRUE.equals(cycleStartNode)) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode);
        } else {
            System.out.println("No cycle in the linked list.");
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
    public boolean hasCycle(Node head) {
        Node slow=head;
        Node fast= head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast= fast.next.next;
            if(slow == fast){
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
}
