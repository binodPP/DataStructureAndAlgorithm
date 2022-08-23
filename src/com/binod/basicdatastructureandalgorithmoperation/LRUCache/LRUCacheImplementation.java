package com.binod.basicdatastructureandalgorithmoperation.LRUCache;

import java.util.*;

public class LRUCacheImplementation {

    int capacity;

    Map<Integer, LRUCACHE> lrucacheMap = new HashMap<>();
    Deque<LRUCACHE> deque = new LinkedList<>();

    public LRUCacheImplementation(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCacheImplementation cache = new LRUCacheImplementation(6);
        cache.putEntryIntoCache(1, "Product-1-Info");
        cache.putEntryIntoCache(2, "Product-2-Info");
        cache.putEntryIntoCache(3, "Product-3-Info");
        cache.putEntryIntoCache(4, "Product-4-Info");
        cache.putEntryIntoCache(5, "Product-5-Info");
        cache.putEntryIntoCache(2, "Product-6-Info");
        cache.putEntryIntoCache(1, "Product-7-Info");

        System.out.println(cache.getFromCache(2));
        if(cache.getFromCache(6) == null){
            cache.putEntryIntoCache(6,"Product-8-Info");
        }

        cache.putEntryIntoCache(9, "Product-9-Info");

        cache.display();

    }

    public void display()
    {

        for (Map.Entry<Integer, LRUCACHE> lrucacheMap1 : lrucacheMap.entrySet()){

            System.out.println("key : " + lrucacheMap1.getKey());
            System.out.println("value : " + lrucacheMap1.getValue().value);
        }
    }

    private void putEntryIntoCache(int key, String value){
        if(lrucacheMap.containsKey(key)){
            LRUCACHE lrucache = lrucacheMap.get(key);
            deque.remove(lrucache);
        }else {
            if(deque.size() == capacity) {
                LRUCACHE lrucache = deque.removeLast();
                lrucacheMap.remove(lrucache.key);
            }
        }

        LRUCACHE newlrucache = new LRUCACHE(key,value);
        deque.addFirst(newlrucache);
        lrucacheMap.put(key,newlrucache);

    }

    private String getFromCache(int key){
            if (lrucacheMap.containsKey(key)) {
                LRUCACHE lrucache = lrucacheMap.get(key);
                deque.remove(lrucache);
                deque.addFirst(lrucache);
                return lrucache.value;
            }

         return null;
    }
}
