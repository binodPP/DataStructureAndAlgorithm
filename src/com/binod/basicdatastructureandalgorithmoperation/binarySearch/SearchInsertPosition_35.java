package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int[] nums={1,3,4,6};
        int target=5;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
       int low=0; int right=nums.length-1;
       int resultIndex=0;
       while(low<=right){
           int mid = low + (right - low)/2;

           if(nums[mid] == target){
               return mid;
           }else if(nums[mid] < target){
               low = mid +1;
               resultIndex= mid+1;
           }else {
               right = mid-1;
               resultIndex = mid;
           }
       }

       return resultIndex;
    }
}
