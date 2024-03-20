package com.systemdesign.lowlevel.cacheapplication.cache.storage;


public interface StorageArea<Key, Value> {
    void addKey(Key key, Value value) throws Exception;
    Value getKey(Key key) throws Exception;
    void remove(Key key);
}
