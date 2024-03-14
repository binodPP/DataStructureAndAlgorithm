package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

//RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.
//
//Implement the RandomizedCollection class:
//
//RandomizedCollection() Initializes the empty RandomizedCollection object.
//bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
//bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
//int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of the same values the multiset contains.
//You must implement the functions of the class such that each function works on average O(1) time complexity.
//
//Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.
public class InsertDeleteGetRandom_duplicate_381 {

    private ArrayList<Integer> list;
    private HashMap<Integer, ArrayList<Integer>> map;
    private Random rand;

    public InsertDeleteGetRandom_duplicate_381() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        list.add(val);
        ArrayList<Integer> indices = map.getOrDefault(val, new ArrayList<>());
        indices.add(list.size() - 1);
        map.put(val, indices);
        return indices.size() == 1; // Returns true if the item is not present.
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Returns false if the item is not present.
        }

        int indexToRemove = map.get(val).remove(0); // Get the index of the first occurrence.
        int lastIndex = list.size() - 1;
        if (indexToRemove != lastIndex) {
            int lastValue = list.get(lastIndex);
            list.set(indexToRemove, lastValue); // Move the last element to the removed position.
            ArrayList<Integer> lastValueIndices = map.get(lastValue);
            for (int i = 0; i < lastValueIndices.size(); i++) {
                if (lastValueIndices.get(i) == lastIndex) {
                    lastValueIndices.set(i, indexToRemove);
                    map.put(lastValue,lastValueIndices);
                    break;
                }
            }
        }
        list.remove(lastIndex); // Remove the last element.
       /* if (map.get(val).isEmpty()) {
            map.remove(val);
        }*/
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }



    public static void main(String[] args) {
        InsertDeleteGetRandom_duplicate_381 randomizedCollection = new InsertDeleteGetRandom_duplicate_381();
        System.out.println(randomizedCollection.insert(1)); // true
        System.out.println(randomizedCollection.insert(1)); // false
        System.out.println(randomizedCollection.insert(2)); // true
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.remove(1)); // true
        System.out.println(randomizedCollection.getRandom());
    }

}
