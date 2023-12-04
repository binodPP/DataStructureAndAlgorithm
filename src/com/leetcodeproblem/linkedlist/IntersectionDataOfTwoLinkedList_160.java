package com.leetcodeproblem.linkedlist;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionDataOfTwoLinkedList_160 {
    int length=0;
    Node head;
    Node tail;

    public static void main(String[] args) {
        IntersectionDataOfTwoLinkedList_160 intersection= new IntersectionDataOfTwoLinkedList_160();
        intersection.addFirst(30);
        intersection.addFirst(15);
        intersection.addFirst(7);
        intersection.addFirst(6);
        intersection.addFirst(3);
        intersection.addFirst(2);
        intersection.addFirst(1);
        intersection.print();

        IntersectionDataOfTwoLinkedList_160 intersection1= new IntersectionDataOfTwoLinkedList_160();

        intersection1.addFirst(30);
        intersection1.addFirst(15);
        intersection1.addFirst(10);
        intersection1.addFirst(9);
        intersection1.addFirst(8);

        intersection1.print();
        System.out.println(getIntersection(intersection.head,intersection1.head));

    }

    public static int getIntersection(Node l1, Node l2){
          int l1Length=0;
          int l2Length=0;
          Node l1Temp=l1;
          //first find the length of both the list
          while(l1Temp != null){
              l1Temp=l1Temp.next;
              l1Length++;
          }

        Node l2Temp=l2;
        while(l2Temp != null){
            l2Temp=l2Temp.next;
            l2Length++;
        }

        //calculate the difference and traverse the longest list till the diff count
        int diffLength=0;
        if(l1Length >= l2Length){
            diffLength=l1Length-l2Length;
            for(int i=1; i <= diffLength;i++){
                l1=l1.next;
            }
        }else {
            diffLength=l2Length-l1Length;
            for(int i=1; i <= diffLength;i++){
                l2=l2.next;
            }
        }

        //now start both the list one by one to traverse
        while(l1 != null && l2 != null){
            if(l1.data == l2.data){
                return l1.data;
            }
            l1=l1.next;
            l2=l2.next;
        }

       return -1;
    }


    public static int getDifference(Node head1,Node head2) {
        int len1 = 0,len2 = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                ++len1; head1 = head1.next;
            }
            if(head2 != null) {
                ++len2; head2 = head2.next;
            }

        }
        return len1-len2;//if difference is neg-> length of list2 > length of list1 else vice-versa
    }
    //Time= O(m+n), space= O(1)
    public static Node intersectionPresent(Node headA,Node headB) {
        int diff = getDifference(headA,headB);
        if(diff < 0)
            while(diff++ != 0) headB = headB.next;
        else while(diff-- != 0) headA = headA.next;
        while(headA != null) {
            if(headA == headB) return headA;
            headB = headB.next;
            headA = headA.next;
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
