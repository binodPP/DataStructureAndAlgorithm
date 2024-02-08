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

        // Initialize head and tail nodes
        head = new Node(-1, -1); // Dummy head node
        tail = new Node(-1, -1); // Dummy tail node
        head.next = tail;
        tail.prev = head;
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


    public static void main(String[] args) {
        // Creating an LRUCache with a capacity of 2
        LRUCacheImplementationWithoutUsingInbuiltLinkedList lruCache = new LRUCacheImplementationWithoutUsingInbuiltLinkedList(2);

        // Putting key-value pairs into the cache
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        // Retrieving values from the cache
        System.out.println(lruCache.get(1)); // Output: 1
        System.out.println(lruCache.get(2)); // Output: 2

        // Putting another key-value pair into the cache, which will evict the least recently used entry (1, 1)
        lruCache.put(3, 3);

        // Retrieving values from the cache
        System.out.println(lruCache.get(1)); // Output: -1 (Key not found, as it was evicted)
        System.out.println(lruCache.get(2)); // Output: 2
        System.out.println(lruCache.get(3)); // Output: 3
    }
}
