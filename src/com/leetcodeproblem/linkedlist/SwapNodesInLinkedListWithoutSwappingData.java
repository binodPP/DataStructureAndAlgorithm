package com.leetcodeproblem.linkedlist;

public class SwapNodesInLinkedListWithoutSwappingData {

    //https://www.youtube.com/watch?v=bSORX7TcFvs
    //https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/

    //1. x and y may or may not be adjacent.
    //2. Either x or y may be a head node.
    //3. Either x or y may be the last node.
    //4. x and/or y may not be present in the linked list.

    //Input : 1->2->3->4->5->6->NULL, x = 1, y = 4
    //Output : 4->2->3->1->5->6->NULL

    //Input : 1->2->3->4->5->NULL , x = 2, y = 4
    //Output : 1->4->3->2->5->NULL

    int length=0;
    Node head=null;
    Node tail=null;
    public static void main(String[] args) {
        SwapNodesInLinkedListWithoutSwappingData swapNodes= new SwapNodesInLinkedListWithoutSwappingData();
        swapNodes.addFirst(6);
        swapNodes.addFirst(5);
        swapNodes.addFirst(4);
        swapNodes.addFirst(3);
        swapNodes.addFirst(2);
        swapNodes.addFirst(1);
        int x=1;
        int y=4;
        swapNodes.print();
        //swapNodes.swapNodesWithoutSwappingData(swapNodes,x,y);
        swapNodes.swapNodesWithoutSwappingDataMethod2(swapNodes.head,x,y);
        swapNodes.print();
    }

    public void swapNodesWithoutSwappingData(Node l1, int x, int y){
        //if x and y are same then there is no need to swap
        if(x == y){
            return;
        }
        //search x data
        Node tempX=l1;
        Node prevX=null;
        while(tempX != null && tempX.data != x){
             prevX=tempX;
             tempX=tempX.next;
        }

        //search y data
        Node tempY=l1;
        Node prevY=null;
        while(tempY != null && tempY.data != y){
            prevY=tempY;
            tempY=tempY.next;
        }

        if(tempX == null || tempY == null){
            return;
        }

        if(prevX != null){
            prevX.next=tempY;
        }else {
            l1=tempY;
        }

        if(prevY != null){
            prevY.next=tempX;
        }else {
            l1=tempX;
        }

        Node result=tempX.next;
        tempX.next=tempY.next;
        tempY.next=result;

    }


    public void swapNodesWithoutSwappingDataMethod2(Node l1, int x, int y){
        //if x and y are same then there is no need to swap
        if(x == y){
            return;
        }
        //search x data
        Node tempX=l1;
        Node prevX=null;
        while(tempX != null && tempX.data != x){
            prevX=tempX;
            tempX=tempX.next;
        }


        //search y data
        Node tempY=l1;
        Node prevY=null;
        while(tempY != null && tempY.data != y){
            prevY=tempY;
            tempY=tempY.next;
        }


        if(tempX == null || tempY == null){
            return;
        }

        Node temp=tempY.next;
        tempY.next=tempX.next;
        tempX.next=temp;

        if(prevX == null){
            l1=tempY;
            prevY.next=tempX;
        }
        if(prevY == null){
            l1=tempX;
            prevX.next=tempY;
        }

        if(prevX !=null && prevY !=null){
            prevX.next=tempY;
            prevY.next=tempX;
        }

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
