package com.systemdesign.lowlevel.cacheapplication.cache.evictionpolicies;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evictKey();
}
