package com.leetcodeproblem.linkedlist;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII_142 {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        LinkedListCycleII_142 findKth= new LinkedListCycleII_142();
        findKth.addFirst(4);
        findKth.addFirst(0);
        findKth.addFirst(2);
        findKth.addFirst(3);

        //print(findKth.head);

        print(detectCycle(findKth.head));
    }

    public static Node detectCycle(Node head) {
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
