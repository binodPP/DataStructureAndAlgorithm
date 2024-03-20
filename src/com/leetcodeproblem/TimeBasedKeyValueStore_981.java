package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/description/
public class TimeBasedKeyValueStore_981 {
    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 timeMap = new TimeBasedKeyValueStore_981();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // Output: bar
        System.out.println(timeMap.get("foo", 3)); // Output: bar
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // Output: bar2
        System.out.println(timeMap.get("foo", 5)); // Output: bar2
    }


    private Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore_981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        TreeMap<Integer, String> treeMap = map.get(key);
        Integer floorKey = treeMap.floorKey(timestamp);
        if (floorKey == null)
            return "";

        return treeMap.get(floorKey);
    }
}
