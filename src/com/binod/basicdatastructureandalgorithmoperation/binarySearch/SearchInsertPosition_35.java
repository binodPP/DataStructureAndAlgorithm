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
       while(low<=right){
           int mid = low + (right - low)/2;
           if(nums[mid] == target){
               return mid;
           }else if(nums[mid] < target){
               low = mid +1;
           }else {
               right = mid-1;
           }
       }

       //Why to return low instead of right?
       //Ans: Termination Condition:
        //
        //The while loop continues until low is less than or equal to right. When low is equal to right, it indicates that the search space has been narrowed down to a single element.
        //At this point, the binary search algorithm checks whether the current element at the mid index is equal to the target element. If it is, the algorithm returns the index of the current element, which is mid.
        //If the target element is not found in the array, the loop terminates when low exceeds right. This condition indicates that the algorithm has finished searching the array and has narrowed down the insertion index of the target element to the range between low and right, where low is greater than right.
        //Returning low:
        //
        //When the target element is not found in the array, the binary search algorithm returns the value of low. This is because low represents the insertion index where the target element should be inserted into the sorted array to maintain its sorted order.
        //If the target element is greater than all elements in the array, low will be equal to nums.length, indicating that the target element should be inserted at the end of the array.
        //If the target element is less than all elements in the array, low will be equal to 0, indicating that the target element should be inserted at the beginning of the array.
        //If the target element falls between two elements in the array, low will represent the index where the target element should be inserted to maintain the sorted order.
       return low;
    }
}
