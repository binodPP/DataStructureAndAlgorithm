package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int prevMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    prevMax = Math.max(dp[j], prevMax);
                }
            }
            dp[i] = prevMax + 1;
            System.out.println(dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
