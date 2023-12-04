package com.systemdesign.cacheapplication;

import com.systemdesign.cacheapplication.cache.factory.CacheFactory;
import com.systemdesign.cacheapplication.cache.service.CacheService;

public class Driver {
    public static void main(String[] args) throws Exception {

        CacheService<Integer,Integer> cacheService = new CacheFactory<Integer, Integer>().defaultCache(3);
        cacheService.add(1,1); //[1]
        cacheService.add(2,2);//[2,1]

        System.out.println(cacheService.get(1)); //[1,2]

        cacheService.add(3,3);//[3,1,2]

        System.out.println(cacheService.get(1)); //[1,2]
        cacheService.add(4,4);//[4,3,1]

        System.out.println(cacheService.get(2));
    }
}
