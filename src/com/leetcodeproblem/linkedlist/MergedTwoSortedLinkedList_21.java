package com.leetcodeproblem.linkedlist;

public class MergedTwoSortedLinkedList_21 {
    int length=0;
    Node head=null;
    Node tail=null;
    public static void main(String[] args) {
        MergedTwoSortedLinkedList_21 merged= new MergedTwoSortedLinkedList_21();
        merged.addFirst(30);
        merged.addFirst(25);
        merged.addFirst(15);
        merged.addFirst(6);
        merged.print(merged.head);

        MergedTwoSortedLinkedList_21 merge1= new MergedTwoSortedLinkedList_21();
        merge1.addFirst(50);
        merge1.addFirst(35);
        merge1.addFirst(27);
        merge1.addFirst(12);

        print(merge1.head);
        Node sortedLinkedList=mergedTwoLinkedList(merged.head,merge1.head);
        print(sortedLinkedList);
        //System.out.println("Find KTH Element is : " + findKth.findKthDataFromEndSecondMethod(findKth,3));
    }

    //Time Complexity=O(M+N), Space Complexity=O(1)
    public static Node mergedTwoLinkedList(Node l1, Node l2){
        Node sorted = null;
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        if(l1 !=null && l2 !=null){
            if(l1.data <= l2.data){
              sorted=l1;
              l1=l1.next;
            }else{
                sorted=l2;
                l2=l2.next;
            }
        }

        Node mergedTail = sorted;

        while (l1 !=null && l2 !=null){

            if(l1.data <= l2.data){
                mergedTail.next=l1;
                l1=l1.next;
            }else {
                mergedTail.next=l2;
                l2=l2.next;
            }
            mergedTail = mergedTail.next;

        }
        if(l1 == null){
            mergedTail.next=l2;

        }else if(l2 == null){
            mergedTail.next=l1;
        }
        return sorted;
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
