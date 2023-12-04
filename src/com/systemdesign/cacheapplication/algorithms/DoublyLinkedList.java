package com.systemdesign.cacheapplication.algorithms;

import com.leetcodeproblem.linkedlist.Node;

public class DoublyLinkedList<E> {
     private DoublyLinkedListNode<E> dummyHead;
     private DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        //Instantiate this as a null value because we will never use this node value
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        //there are no item so join dummyHead and dummyTail
        dummyHead.next = dummyTail;
        dummyTail.next = dummyHead;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtFirst(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> headNext = dummyHead.next;
        headNext.prev = node;
        node.next = headNext;
        node.prev = dummyHead;
        dummyHead.next = node;
    }

    public boolean isItemPresent(){
        return dummyHead.next != dummyTail;
    }

    public DoublyLinkedListNode<E> getLastNode(){
        if(!isItemPresent()){
            return null;
        }
        return dummyTail.prev;
    }
}
