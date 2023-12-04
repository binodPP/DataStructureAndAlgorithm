package com.systemdesign.cacheapplication.cache.evictionpolicies;

import com.systemdesign.cacheapplication.algorithms.DoublyLinkedList;
import com.systemdesign.cacheapplication.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoublyLinkedList<Key> doublyLinkedList;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            doublyLinkedList.detachNode(mapper.get(key));
        }else {
            DoublyLinkedListNode<Key> newNode = new DoublyLinkedListNode<>(key);
            mapper.put(key, newNode);
        }
        doublyLinkedList.addNodeAtFirst(mapper.get(key));
    }

    @Override
    public Key evictKey() {
       DoublyLinkedListNode<Key> node = doublyLinkedList.getLastNode();
       if(node == null){
           return null;
       }
       doublyLinkedList.detachNode(node);
       return node.getElement();
    }
}
