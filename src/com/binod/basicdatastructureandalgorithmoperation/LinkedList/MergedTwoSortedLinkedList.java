package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class MergedTwoSortedLinkedList {
    int length=0;
    Node head=null;
    Node tail=null;
    public static void main(String[] args) {
        MergedTwoSortedLinkedList merged= new MergedTwoSortedLinkedList();
        merged.addFirst(30);
        merged.addFirst(25);
        merged.addFirst(15);
        merged.addFirst(6);
        merged.print();

        MergedTwoSortedLinkedList merge1= new MergedTwoSortedLinkedList();
        merge1.addFirst(50);
        merge1.addFirst(35);
        merge1.addFirst(27);
        merge1.addFirst(12);

        merge1.print();
        MergedTwoSortedLinkedList mergedTwoSortedLinkedList=mergedTwoLinkedList(merged,merge1);
        mergedTwoSortedLinkedList.print();
        //System.out.println("Find KTH Element is : " + findKth.findKthDataFromEndSecondMethod(findKth,3));
    }

    public static MergedTwoSortedLinkedList mergedTwoLinkedList(MergedTwoSortedLinkedList l1, MergedTwoSortedLinkedList l2){
        MergedTwoSortedLinkedList sorted = new MergedTwoSortedLinkedList();
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        if(l1 !=null && l2 !=null){
            if(l1.head.data <= l2.head.data){
              sorted.head=l1.head;
              sorted.tail=l1.head;
              l1.head=l1.head.next;
            }else{
                sorted.head=l2.head;
                sorted.tail=l2.head;
                l2.head=l2.head.next;
            }
        }


        while (l1 !=null && l2 !=null){
            MergedTwoSortedLinkedList temp=new MergedTwoSortedLinkedList();

            if(l1.head.data <= l2.head.data){
                temp.head=l1.head;
                sorted.tail.next=temp.head;
                sorted.tail=temp.head;
                l1.head=l1.head.next;
            }else {
                temp.head=l2.head;
                sorted.tail.next=temp.head;
                sorted.tail=temp.head;
                l2.head=l2.head.next;
            }

            if(l1.head == null){
                sorted.tail.next=l2.head;
                sorted.tail=l2.head;
                return sorted;
            }else if(l2.head == null){
                sorted.tail.next=l1.head;
                sorted.tail=l1.head;
                return sorted;
            }

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
}
