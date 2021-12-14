package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.HashSet;

public class UnionIntersectionOfArray {
    //Write a java program to find union and intersection of multiple arrays?

    public static void main(String[] args) {
        int[] inputArray1 = {2, 3, 4, 7, 1};

        int[] inputArray2 = {4, 1, 3, 5};

        int[] inputArray3 = {8, 4, 6, 2, 1};

        int[] inputArray4 = {7, 9, 4, 1};

        unionIntersectionArray(inputArray1, inputArray2, inputArray3, inputArray4);
    }

    public static void unionIntersectionArray(int[] ... arrays) {

        //Union of multiple arrays
        HashSet hashSet = new HashSet();
        for (int[] array : arrays) {
            System.out.println("Arrays data : " + Arrays.toString(array));
            for (int i : array) {
                hashSet.add(i);
            }
        }
        System.out.println(hashSet);


        //Intersection of multiple array
        HashSet<Integer> intersection = new HashSet(Arrays.asList(arrays[0]));
        for (int i=1; i<arrays.length;i++) {
            HashSet<Integer> hashSet1 = new HashSet(Arrays.asList(arrays[i]));
            intersection.retainAll(hashSet1);
        }
        System.out.println(intersection);
    }

}
