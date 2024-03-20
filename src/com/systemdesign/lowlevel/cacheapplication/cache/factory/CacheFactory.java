package com.systemdesign.lowlevel.cacheapplication.cache.factory;

import com.systemdesign.lowlevel.cacheapplication.cache.evictionpolicies.LRUEvictionPolicy;
import com.systemdesign.lowlevel.cacheapplication.cache.service.CacheService;
import com.systemdesign.lowlevel.cacheapplication.cache.storage.HashMapBasedStorageArea;

public class CacheFactory<Key,Value> {
    public CacheService<Key,Value> defaultCache(final int capacity){
        return new CacheService<Key,Value>(new HashMapBasedStorageArea<Key,Value>(capacity)
                , new LRUEvictionPolicy<Key>());
    }
}
