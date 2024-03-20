package com.systemdesign.lowlevel.cacheapplication.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorageArea<Key,Value> implements StorageArea<Key,Value> {
    private Map<Key,Value> storage;
    private final Integer capacity;

    public HashMapBasedStorageArea(Integer capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void addKey(Key key, Value value) throws Exception {
        if(isStorageFull()){
            throw new Exception();
        }else {
            storage.put(key,value);
        }
    }

    @Override
    public Value getKey(Key key) throws Exception {
        if(!storage.containsKey(key)){
            System.out.println("Exception from getKey Function");
            throw new Exception();
        }
        return storage.get(key);
    }

    @Override
    public void remove(Key key) {
        if(!storage.containsKey(key)){
            System.out.println("Exception from addKey Function");
        }else {
            storage.remove(key);
        }

    }
    private boolean isStorageFull(){
        return storage.size() == capacity;
    }
}
