package com.systemdesign.cacheapplication.cache.service;

import com.systemdesign.cacheapplication.cache.evictionpolicies.EvictionPolicy;
import com.systemdesign.cacheapplication.cache.storage.StorageArea;

public class CacheService<Key,Value> {
    private final StorageArea<Key,Value> keyValueStorageArea;
    private final EvictionPolicy<Key> evictionPolicy;

    public CacheService(StorageArea<Key, Value> keyValueStorageArea, EvictionPolicy<Key> evictionPolicy) {
        this.keyValueStorageArea = keyValueStorageArea;
        this.evictionPolicy = evictionPolicy;
    }

    public void add(Key key, Value value) throws Exception {
        try {
            keyValueStorageArea.addKey(key,value);
            evictionPolicy.keyAccessed(key);
        }catch (Exception exception){
            System.out.println("Storage full");
            Key keyToRemove = evictionPolicy.evictKey();
            if(keyToRemove == null){
                System.out.println("Key is null");
            }
            keyValueStorageArea.remove(keyToRemove);
            keyValueStorageArea.addKey(key,value);
        }
    }

    public Value get(Key key){
        try {
            Value value = keyValueStorageArea.getKey(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }catch (Exception exception){
            System.out.println("Key not available in storage");
           return null;
        }
    }
}
