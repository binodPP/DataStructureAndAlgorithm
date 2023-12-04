package com.leetcodeproblem.linkedlist;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII_142 {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        LinkedListCycleII_142 cycleStartFinder = new LinkedListCycleII_142();
        Node cycleStartNode = cycleStartFinder.detectCycle(head);
        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode.data);
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }

    public Node detectCycle(Node head) {
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
               return start;
           }
       }
       return null;
    }
}
