package com.leetcodeproblem;

//https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150


//The RandomizedSet class uses an ArrayList to store the elements and a HashMap to store the mapping
// of each element to its index in the ArrayList. This allows for O(1) average time complexity for
// insert and remove operations.
//
//In the insert method, we first check if the element already exists in the set using the HashMap.
// If it does, we return false. Otherwise, we add the element to the ArrayList and update the
// HashMap with the new index.
//
//In the remove method, we first check if the element exists in the set using the HashMap.
// If it doesn't, we return false. Otherwise, we swap the element with the last element in
// the ArrayList, update the indices in the HashMap, and remove the last element from the ArrayList.
//
//The getRandom method generates a random index within the range of the ArrayList size and
// retrieves the element at that index.
//
//Note: The code assumes that the input values are within the valid range of the integer data type.

import java.util.*;

public class InsertDeleteGetRandom_380 {
    List<Integer> indexArray; // A resizable array to hold the elements
    Map<Integer, Integer> integerMap; // A hash map to store the indexes of elements in arr
    Random random;

    // Constructor to initialize the array and hash map and Random
    public InsertDeleteGetRandom_380() {
        indexArray = new ArrayList<>();
        integerMap = new HashMap<>();
        random = new Random();
    }

    public boolean insertData(int val) {
        if(integerMap.containsKey(val)){
            return false;
        }

        indexArray.add(val);
        integerMap.put(val,indexArray.size()-1);
        return true;
    }

    public boolean removeData(int val) {
         if(!integerMap.containsKey(val)){
             return false;
         }

         int index= integerMap.get(val);
         int lastElement = indexArray.get(indexArray.size()-1);
         indexArray.set(index,lastElement);
         integerMap.put(lastElement,index);
         integerMap.remove(val);
         indexArray.remove(indexArray.size()-1);

         return true;
    }

    public int getRandomData() {
       int index = random.nextInt(indexArray.size());
       return indexArray.get(index);
    }

    public int searchData(int val) {
       return integerMap.get(val);
    }

    @Override
    public String toString() {
        return "InsertDeleteGetRandom_380{" +
                "indexArray=" + indexArray +
                ", integerMap=" + integerMap +
                ", random=" + random +
                '}';
    }

    public static void main(String[] args) {
        /*InsertDeleteGetRandom_380 insertDeleteGetRandom_380 = new InsertDeleteGetRandom_380();
        insertDeleteGetRandom_380.insertData(10);
        insertDeleteGetRandom_380.insertData(20);
        insertDeleteGetRandom_380.insertData(30);
        insertDeleteGetRandom_380.insertData(40);

        System.out.println(insertDeleteGetRandom_380);

        System.out.println(insertDeleteGetRandom_380.searchData(30));

        System.out.println(insertDeleteGetRandom_380.removeData(20));

        System.out.println(insertDeleteGetRandom_380.insertData(50));

        System.out.println(insertDeleteGetRandom_380.searchData(50));
        System.out.println(insertDeleteGetRandom_380);
        System.out.println(insertDeleteGetRandom_380.getRandomData());*/


        InsertDeleteGetRandom_380 insertDeleteGetRandom_380 = new InsertDeleteGetRandom_380();
        System.out.println(insertDeleteGetRandom_380.removeData(0));
        System.out.println(insertDeleteGetRandom_380.removeData(0));
        System.out.println(insertDeleteGetRandom_380.insertData(0));
        System.out.println(insertDeleteGetRandom_380.getRandomData());
        System.out.println(insertDeleteGetRandom_380.removeData(0));
        System.out.println(insertDeleteGetRandom_380.insertData(0));
    }

}
