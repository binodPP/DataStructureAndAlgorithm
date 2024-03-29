package com.leetcodeproblem.linkedlist;

public class DeleteLastOccurrence {
    int length = 0;
    Node head;
    Node tail;

    public static void main(String[] args) {
        DeleteLastOccurrence lastOccurrence = new DeleteLastOccurrence();
        lastOccurrence.addFirst(9);
        lastOccurrence.addFirst(8);
        lastOccurrence.addFirst(6);
        lastOccurrence.addFirst(3);
        lastOccurrence.addFirst(4);
        lastOccurrence.addFirst(2);
        lastOccurrence.print();
        // lastOccurrence.deleteLast(lastOccurrence.head, 4);
        // lastOccurrence.print();
        lastOccurrence.deleteNode(lastOccurrence.head, 6);
        lastOccurrence.print();

    }

    //Generic code to delete node from first, last, and from any position by matching key in the linked list
    public void deleteLast(Node node, int key) {
        Node prev = null;
        Node current = node;

        if(current != null && current.data == key){
            head = current.next;
        }
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found in the linked list.");
            return;
        } else {
            prev.next = current.next;
        }
    }

    //Generic code to delete node from first, last, and from any position in the linked list
    public void deleteNode(Node node, int pos) {
        Node prev = null;
        Node current = node;
        for (int i = 1; i < pos; i++) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = current.next;
        }

        if (current == null) {
            System.out.println("Position not found");
        }else {
            prev.next = current.next;
        }
}

    public void addFirst(int data) {
        Node nodeData = new Node(data);
        if (length == 0) {
            System.out.println("LinkedList is empty, adding the data in it");
            head = nodeData;
            tail = nodeData;
            length++;
        } else {
            nodeData.next = head;
            head = nodeData;
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

    public void print(Node node) {
        System.out.println("Printing the Singly LinkedList : ");
        StringBuffer str = new StringBuffer();
        while (node != null) {
            str.append(node.data).append("->");
            System.out.println(str.toString().substring(0, str.length() - 2));
            node = node.next;
        }
    }
}
