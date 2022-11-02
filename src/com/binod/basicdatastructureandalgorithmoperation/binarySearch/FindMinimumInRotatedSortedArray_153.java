package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//NOTE: All element is uniques
public class FindMinimumInRotatedSortedArray_153 {
    public static void main(String[] args) {
       // int[] nums = {11,13,15,17};
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
      int left=0; int right=nums.length-1;

      if(nums.length ==1){
          return nums[0];
      }

      if(nums.length ==2){
          return Math.min(nums[0],nums[1]);
      }

      if(nums[0] < nums[nums.length-1]){
          return nums[0];
      }

      while(left<=right){
          int mid = left + (right-left)/2;

          if(nums[mid] > nums[mid+1]){
              return nums[mid+1];
          }

          if(nums[mid-1] > nums[mid]){
              return nums[mid];
          }

          if(nums[left] < nums[mid]){
              left = mid+1;
          }else {
              right = mid -1;
          }
      }
      return -1;
    }
}
