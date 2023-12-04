package com.systemdesign.cacheapplication.cache.factory;

import com.systemdesign.cacheapplication.cache.evictionpolicies.LRUEvictionPolicy;
import com.systemdesign.cacheapplication.cache.service.CacheService;
import com.systemdesign.cacheapplication.cache.storage.HashMapBasedStorageArea;
import com.systemdesign.cacheapplication.cache.storage.StorageArea;

public class CacheFactory<Key,Value> {
    public CacheService<Key,Value> defaultCache(final int capacity){
        return new CacheService<Key,Value>(new HashMapBasedStorageArea<Key,Value>(capacity)
                , new LRUEvictionPolicy<Key>());
    }
}
