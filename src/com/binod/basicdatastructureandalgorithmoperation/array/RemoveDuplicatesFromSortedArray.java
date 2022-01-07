package com.binod.basicdatastructureandalgorithmoperation.array;

public class RemoveDuplicatesFromSortedArray {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
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
