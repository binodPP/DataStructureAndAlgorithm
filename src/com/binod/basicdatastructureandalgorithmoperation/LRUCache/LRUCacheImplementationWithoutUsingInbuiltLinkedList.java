package com.binod.basicdatastructureandalgorithmoperation.LRUCache;

import java.util.HashMap;
import java.util.Map;
//https://www.enjoyalgorithms.com/blog/implement-least-recently-used-cache
//https://www.baeldung.com/java-lru-cache
public class LRUCacheImplementationWithoutUsingInbuiltLinkedList {
    Node head;
    Node tail;
    Map<Integer, Node> integerNodeMap;
    int capacity=0;
    public LRUCacheImplementationWithoutUsingInbuiltLinkedList(int capacity) {
        this.capacity = capacity;
        this.integerNodeMap = new HashMap<>();
    }

    public int get(int key) {
        if(integerNodeMap.containsKey(key)) {
            Node node = integerNodeMap.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (integerNodeMap.containsKey(key)) {
            removeNode(integerNodeMap.get(key));
        }
        if (integerNodeMap.size() == capacity) {
            removeNode(tail.prev);
        }
        insertNode(new Node(key, value));
    }


    public void removeNode(Node node) {
        integerNodeMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(Node node) {
        integerNodeMap.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
