package com.leetcodeproblem.linkedlist;

public class MergeKSortedLinkedLists {
    //https://leetcode.com/problems/merge-k-sorted-lists/
    int length=0;
    Node head=null;
    public static void main(String[] args) {
       int k=3;
        Node[] lists = new Node[k];

        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node head=mergeKLists(lists);
        print(head);

    }

    public static Node mergeKLists(Node[] lists) {
        if(lists.length ==0){
            return null;
        }
          if(lists.length ==1){
              return lists[0];
          }

          Node head= mergeTwoLinkedLists(lists[0],lists[1]);
          for(int i=2; i<lists.length; i++){
              head=mergeTwoLinkedLists(head,lists[i]);
          }

        return head;
    }

    public static Node mergeTwoLinkedLists(Node list1, Node list2) {
         if(list1==null){
             return list2;
         }
         if (list2==null){
             return list1;
         }
         Node dummy=new Node(0);
         Node current = dummy;

         while (list1 !=null && list2 !=null){
             if(list1.data<=list2.data){
                 current.next=list1;
                 list1=list1.next;
             }else {
                 current.next=list2;
                 list2=list2.next;
             }
             current=current.next;
         }
         if(list1 !=null){
             current.next=list1;
         }
         if(list2 !=null){
             current.next=list2;
         }
        return dummy.next;
    }

    public static void print(Node l1) {
        System.out.println("Printing the Singly LinkedList : ");
        Node temp = l1;
        StringBuffer str = new StringBuffer();
        while (temp != null) {
            str.append(temp.data).append("->");
            System.out.println(str.toString().substring(0, str.length() - 2));
            temp = temp.next;
        }
    }
}
