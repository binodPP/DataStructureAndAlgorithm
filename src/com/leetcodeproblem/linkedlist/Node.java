package com.leetcodeproblem.linkedlist;

public class Node {
    int data;
    Node next;
    Node prev;
    // Constructor for SinglyLinkList
    public Node(){};
    public Node(int d) {
        this.data = d;
        next = null;
        prev=null;
    }

    public Node(int key, Node next) {
        this.data=key;
        this.next = next;
    }
}