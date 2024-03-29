package com.systemdesign.lowlevel.cacheapplication.algorithms;

public class DoublyLinkedListNode<E> {
      DoublyLinkedListNode<E> next;
      DoublyLinkedListNode<E> prev;
      E element;

    public DoublyLinkedListNode(E element) {
        this.next = null;
        this.prev = null;
        this.element = element;
    }

    public E getElement() {
        return element;
    }
}
