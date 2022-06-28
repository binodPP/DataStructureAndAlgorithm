package com.leetcodeproblem.twopointerprob;

public class RemoveDuplicatesFromSortedArray_26 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(removeDuplicatesPattern2(nums));

    }

    //Pattern1: TimeComplexity= O(n), space complexity= O(1)
    public static int removeDuplicatesPattern1(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
               i++;
            }

            nums[i]=nums[j];
        }

        System.out.println("Total unique element = "+ i+1);
        for (int j=0; j< nums.length; j++){
            System.out.println("Unique array element : " + nums[j]);
        }

        return i+1;

    }

    //Pattern2: TimeComplexity= O(n), space complexity= O(1)
    public static int removeDuplicatesPattern2(int[] nums) {
      if(nums.length ==0){
          return 0;
      }
      if(nums.length == 1){
          return 1;
      }

      int counter=0;
      for(int i=0; i<nums.length; i++){
          if(i < nums.length-1 && nums[i] == nums[i+1]){
              continue;
          }
          nums[counter]=nums[i];
          counter++;
      }

        System.out.println("Total unique element = "+ counter);
        for (int j=0; j< nums.length; j++){
            System.out.println("Unique array element : " + nums[j]);
        }

        return counter;

    }
}
