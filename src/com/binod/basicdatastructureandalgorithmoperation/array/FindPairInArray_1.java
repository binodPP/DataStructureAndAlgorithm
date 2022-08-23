package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairInArray_1 {


    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int k =5;

        int array1[]={2,7,6,15,3};
        int target=9;
        //getPairedData(array,k);
        //getPairedDataUsingHashMap(array,k);
        //addTwoNumberToMatchTargetNumber(array1,target);
        addTwoNumberToMatchTargetNumberUsingTwoPointerConcept(array1,target);
        binarySearchApproach(array1,target);
    }

    //TimeComplexity = O(nlog(n)), Space = O(1)
    public static void addTwoNumberToMatchTargetNumberUsingTwoPointerConcept(int[] array, int k){
        //https://leetcode.com/problems/two-sum/
        int left=0;
        int right= array.length-1;
        Arrays.sort(array);

        while(left<= right){
            if(array[left] + array[right] == k){
                System.out.println("Pair is : ");
                System.out.println(array[left] + "+" + array[right] + "=" + k);
                left++;
                right--;
            }else if (array[left] + array[right] < k){
                left++;
            }else {
                right--;
            }
        }
    }

    //TimeComplexity = O(n log(n)), Space = O(1)
    public static void binarySearchApproach(int[] array, int k){

        Arrays.sort(array);

        for(int i=0; i< array.length; i++){

            int index= binarySearch(array,0, array.length-1, k-array[i]);

            if(index != -1){
                System.out.println("Pair is : "+array[i]+"+"+array[index]+"="+k);
            }
        }

    }

    //TimeComplexity = O(n), Space = O(n)
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

    //TimeComplexity = O(n*n), Space = O(1)
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

    //TimeComplexity = O(n), Space = O(n)
    public static void getPairedDataUsingHashMap(int[] array, int k){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){

            if(map.containsKey(array[i]))
                System.out.println(array[i] +"+"+ map.get(array[i])+"="+k);
            else
                map.put(k-array[i], array[i]);
        }

    }

    public static int binarySearch(int[] nums, int left, int right, int target){

        while(left<=right){

            int mid = (left + right)/2;

            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        return -1;
    }
}
