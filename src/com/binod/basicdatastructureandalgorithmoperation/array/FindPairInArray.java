package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.HashMap;
import java.util.Map;

public class FindPairInArray {


    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int k =5;

        int array1[]={2,7,11,15};
        int target=9;
        getPairedData(array,k);
        getPairedDataUsingHashMap(array,k);
        addTwoNumberToMatchTargetNumber(array1,target);
    }

    public static void addTwoNumberToMatchTargetNumber(int[] array, int k){
        //https://leetcode.com/problems/two-sum/
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            int sum=k-array[i];
            if(map.containsKey(sum)) {
                System.out.println("addTwoNumberToMatchTargetNumber : " + i + "," + map.get(sum));
            }else {
                map.put(array[i],i);
            }
        }

    }

    public static void getPairedData(int[] array, int k){
        int length= array.length;
        for(int i=0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((array[i] + array[j]) == 5) {
                    System.out.println("Pair is : ");
                    System.out.println(array[i] + "+" + array[j] + "=" + k);
                }
            }
        }
    }

    public static void getPairedDataUsingHashMap(int[] array, int k){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){

            if(map.containsKey(array[i]))
                System.out.println(array[i] +"+"+ map.get(array[i])+"="+k);
            else
                map.put(k-array[i], array[i]);
        }

    }
}
