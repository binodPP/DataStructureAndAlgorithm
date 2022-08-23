package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class FindFirstOrLastOccurrenceInSortedArray {
    //https://www.techiedelight.com/find-first-or-last-occurrence-of-a-given-number-sorted-array/
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target = 9;

        System.out.println("FirstOccurrence : " + findFirstOccurrence(nums,target));
        System.out.println("LastOccurrence : " + findLastOccurrence(nums,target));
    }

    public static int findFirstOccurrence(int[] nums, int target){
       int left=0;
       int right=nums.length-1;
       int resultIndex = -1;

       while(left <= right){
           int mid = (left + right)/2;

           if(target == nums[mid]){
               resultIndex = mid ;
               right = mid -1;
           }else if(target < nums[mid]){
               right = mid -1;
           }else {
               left = mid +1;
           }
       }

       return resultIndex;
    }

    public static int findLastOccurrence(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int resultIndex = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(target == nums[mid]){
                resultIndex = mid ;
                left = mid +1;
            }else if(target < nums[mid]){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        return resultIndex;
    }
}
