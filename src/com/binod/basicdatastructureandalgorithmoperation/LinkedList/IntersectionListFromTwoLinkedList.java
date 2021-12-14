package com.binod.basicdatastructureandalgorithmoperation.LinkedList;

public class IntersectionListFromTwoLinkedList {
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
        IntersectionListFromTwoLinkedList intersection= new IntersectionListFromTwoLinkedList();
        intersection.addFirst(30);
        intersection.addFirst(15);
        intersection.addFirst(7);
        intersection.addFirst(6);
        intersection.addFirst(3);
        intersection.addFirst(2);
        intersection.addFirst(1);
        intersection.print();

        IntersectionListFromTwoLinkedList intersection1= new IntersectionListFromTwoLinkedList();

        intersection1.addFirst(30);
        intersection1.addFirst(15);
        intersection1.addFirst(10);
        intersection1.addFirst(9);
        intersection1.addFirst(3);

        intersection1.print();
        Node finalNode=intersection1.getIntersectionNode(intersection.head,intersection1.head);
        print(finalNode);

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
