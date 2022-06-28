package com.leetcodeproblem.linkedlist;

public class IntersectionListFromTwoLinkedList_160 {
    //First list is
    //4 10 11 15 20
    //Second list is
    //2 4 8 10
    //Intersection list is
    //10 4

    int length=0;
    Node head;
    Node tail;
    public static void main(String[] args) {
        IntersectionListFromTwoLinkedList_160 intersection= new IntersectionListFromTwoLinkedList_160();
        intersection.addFirst(5);
        intersection.addFirst(4);
        intersection.addFirst(8);
        intersection.addFirst(1);
        intersection.addFirst(4);
        intersection.print();

        IntersectionListFromTwoLinkedList_160 intersection1= new IntersectionListFromTwoLinkedList_160();

        intersection1.addFirst(5);
        intersection1.addFirst(4);
        intersection1.addFirst(8);
        intersection1.addFirst(1);
        intersection1.addFirst(6);
        intersection1.addFirst(5);

        intersection1.print();
        //Node finalNode=intersection1.getIntersectionNode(intersection.head,intersection1.head);
        Node node1= intersectionPresent(intersection.head,intersection1.head);
        print(node1);

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
        return headA;

    }

    public Node getIntersectionNode(Node l1, Node l2){
        //Assuming two linked list are in sorted order if not then need to sort first
        if(l1 !=null && l2==null){
            return l1;
        }

        if(l1==null && l2 ==null){
            return null;
        }

        if(l1==null && l2!=null){
            return l2;
        }

        Node result=null;
        while (l1 !=null && l2 !=null){
            if(l1.data < l2.data){
                l1=l1.next;
            }else if(l1.data > l2.data){
                l2=l2.next;
            }else {
               Node temp= new Node(l1.data);

               if(result==null){
                   result=temp;
                   tail=temp;
               }else {
                   tail.next=temp;
                   tail=temp;
               }
               l1=l1.next;
               l2=l2.next;
            }
        }

        return result;
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
