package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class FindNumberOf1InSortedBinaryArray {
    //https://www.techiedelight.com/find-number-1s-sorted-binary-array/
    public static void main(String[] args) {
      int[] nums = {0, 0, 0, 0, 1, 1, 1};

        System.out.println(count(nums,0,nums.length-1));
    }

    //TimeComplexity= O(log(n)), spaceComplexity= O(1)
    public static int count(int[] nums, int left, int right){
          if(nums==null && nums.length==0){
              return 0;
          }

          if(nums[right] == 0){
              return 0;
          }

          if(nums[left] == 1){
              return right-left+1;
          }

          int mid= (left+right)/2;

          return count(nums,left,mid) + count(nums,mid+1,right);
    }
}
