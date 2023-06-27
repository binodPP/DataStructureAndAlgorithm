package com.leetcodeproblem;
//https://leetcode.com/problems/subarray-product-less-than-k/
public class SubarrayProductLessThanK_713 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        //int[] nums = {1,1,1};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums,k));
        System.out.println(numSubarrayProductLessThanKPattern2(nums,k));
    }

    //TimeComplexity= O(n), space complexity= O(1)
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int left=0;
        int count=0;
        if(k<1 && nums.length >1){
            return 0;
        }

        for (int right=0; right < nums.length; right++){
            prod= prod * nums[right];

            while (left <= right && prod >= k){
                prod = prod / nums[left];
                left++;
            }
            //formula to find the count including the current element
            count = count + right - left + 1;
        }
        return count;
    }


    //Pattern-2 , TimeComplexity= O(n*n), space complexity= O(1)
    public static int numSubarrayProductLessThanKPattern2(int[] nums, int k) {
        int prod=1;
        int count=0;
        if(k<1 && nums.length >1){
            return 0;
        }

        for (int i=0; i < nums.length; i++){
            prod= nums[i];
            if(prod < k){
                count++;
            }

            for (int j=i+1; j< nums.length && prod < k; j++){
                prod=prod * nums[j];

                if(prod < k){
                    count++;
                }
            }

        }
        return count;
    }
}
