package com.leetcodeproblem.linkedlist;

public class ReverseNodesInKGroup_25 {
//https://leetcode.com/problems/reverse-nodes-in-k-group/
    //https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        print(node);
        int k=3;

        print(reverseKGroup(node,k));

    }

    public static Node reverseKGroup(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node current= head;
      int size=0;
      while (current != null){
          current=current.next;
          size++;
      }
        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node cur;
        Node nex;

        while(size >= k) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1;i<k;i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            size -= k;
        }
        return dummyHead.next;
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
