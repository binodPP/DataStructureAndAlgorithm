package com.leetcodeproblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/two-sum/
public class FindPairInArrayOrTwoSumProb_1 {


    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int k =5;

        int array1[]={2,7,11,15};
        int target=9;
        //getPairedData(array,k);
        //getPairedDataUsingHashMap(array,k);
        addTwoNumberToMatchTargetNumber(array1,target);
        addTwoNumberToMatchTargetNumberWithTwoPointer(array1,target);
        addTwoNumberToMatchTargetNumberWithBinarySearch(array1,target);
    }

    public static void addTwoNumberToMatchTargetNumber(int[] array, int k){
        //https://leetcode.com/problems/two-sum/
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            int sum=k-array[i];
            if(map.containsKey(sum)) {
                System.out.println("addTwoNumberToMatchTargetNumber : " + map.get(sum) + "," +i);
            }else {
                map.put(array[i],i);
            }
        }

    }

    public static void addTwoNumberToMatchTargetNumberWithTwoPointer(int[] array, int k){
        //https://leetcode.com/problems/two-sum/
       int start=0, end=array.length-1;
        Arrays.sort(array);
       while(start < end){
           if(array[start]+ array[end] == k){
               System.out.println("addTwoNumberToMatchTargetNumberWithTwoPointer : " + start + "," +end);
           }
           if(array[start]+ array[end] < k){
               start++;
           }else {
               end--;
           }
       }

    }

    public static void addTwoNumberToMatchTargetNumberWithBinarySearch(int[] array, int k){
        //https://leetcode.com/problems/two-sum/
        Arrays.sort(array);

        for (int i=0; i<array.length; i++){
            int index = binarySearch(k-array[i],array,0, array.length-1);
            if(index != -1){
                System.out.println("addTwoNumberToMatchTargetNumberWithBinarySearch : " + array[i] + "," +array[index]);
            }
        }

    }

    public static int binarySearch(int target,int[] array, int start, int end){

         while(start <=end){
             int mid= start + (end- start)/2;

             if(array[mid] == target){
                 return mid;
             }else if(array[mid] < target){
                 start = mid+1;
             }else {
                 end = mid -1;
             }
         }
         return -1;
    }

    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result= new int[2];
        for(int i=0;i<nums.length;i++){
            int sum=target-nums[i];
            if(map.containsKey(sum)) {
                result[0]=i;
                result[1]=map.get(sum);
            }else {
                map.put(nums[i],i);
            }
        }
        return result;
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
