package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.HashSet;

public class FindFirstDuplicateElement {

    public static void main(String[] args) {
        int[] array={5,4,2,3,1,3,2,};
        int min=-1;
        HashSet hashSet = new HashSet();
        for(int i=array.length-1; i >=0; i--){
            if(hashSet.contains(array[i])){
                min=i;
            }else {
                hashSet.add(array[i]);
            }
        }

        if(min !=-1){
            System.out.println("First Duplicate Element : "+array[min]);
        }
    }

    public int findDuplicate(int[] nums) {

        int duplicateIndex=-1;
        HashSet hashSet = new HashSet();
        for(int i=nums.length-1; i >=0; i--){
            if(hashSet.contains(nums[i])){
                duplicateIndex=i;
            }else {
                hashSet.add(nums[i]);
            }
        }

        if(duplicateIndex !=-1){
            return nums[duplicateIndex];
        }
        return -1;
    }
}
