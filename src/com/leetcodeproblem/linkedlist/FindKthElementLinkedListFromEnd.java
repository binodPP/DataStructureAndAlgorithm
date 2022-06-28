package com.leetcodeproblem.linkedlist;

public class FindKthElementLinkedListFromEnd {
    int length=0;
    Node head=null;
    Node tail=null;

    public static void main(String[] args) {
        FindKthElementLinkedListFromEnd findKth= new FindKthElementLinkedListFromEnd();
        findKth.addFirst(1);
        findKth.addFirst(2);
        findKth.addFirst(3);
        findKth.addFirst(4);
        findKth.addFirst(5);
        findKth.addFirst(6);
        findKth.print();
        System.out.println("Find KTH Element is : " + findKth.findKthDataFromEndFirstMethod(findKth,3));
        System.out.println("Find KTH Element is : " + findKth.findKthDataFromEndSecondMethod(findKth,3));
    }

    //Method 1, to find the total node in linkedlist then start search
    public int findKthDataFromEndFirstMethod(FindKthElementLinkedListFromEnd findKthElement, int kthNode){
        int count=0;
        Node temp= findKthElement.head;
        while(temp !=null){
            count++;
            temp=temp.next;
        }

        Node current= findKthElement.head;
        for (int i=1; i < count-kthNode+1; i++){
            current=current.next;
        }
        return current.data;
    }

    //Method 2, using two pointer

    public int findKthDataFromEndSecondMethod(FindKthElementLinkedListFromEnd findKthElement, int kthNode){
        Node first=findKthElement.head;
        Node second = findKthElement.head;
        for (int i=1; i < kthNode; i++){
            first=first.next;
        }

        while(first.next !=null){
            first=first.next;
            second=second.next;
        }
      return second.data;
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
