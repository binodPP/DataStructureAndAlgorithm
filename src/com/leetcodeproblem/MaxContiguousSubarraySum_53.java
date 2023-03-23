package com.leetcodeproblem;
//https://leetcode.com/problems/maximum-subarray/
//https://www.geeksforgeeks.org/print-the-maximum-subarray-sum/
//using kadane's algorithm
/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        Example:

        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.*/
public class MaxContiguousSubarraySum_53 {
    public static void main(String[] args) {
        int[] array={5,4,-1,7,8};
        maxSubArray(array);
    }

    private static void maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        //Used below varibale just to print max subarray also
        int endIndex=0;
        int temp=0;

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
            if(maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                endIndex=i;
            }

        }

        int startIndex=endIndex;
        temp = maxSoFar;
        while (startIndex >=0){
            temp = temp - nums[startIndex];

            if(temp == 0){
                break;
            }
            startIndex--;
        }

        System.out.println(startIndex +" " + endIndex);
        for (int j= startIndex ; j<= endIndex; j++){
            System.out.println(nums[j]);
        }
        System.out.println(maxSoFar);
    }
}