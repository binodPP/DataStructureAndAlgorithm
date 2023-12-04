package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK_974 {

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK_974 subarraysDivByK = new SubarraySumsDivisiblebyK_974();

        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        System.out.println(subarraysDivByK.subarraysDivByK(nums1, k1)); // Output: 7

        int[] nums2 = {5};
        int k2 = 9;
        System.out.println(subarraysDivByK.subarraysDivByK(nums2, k2)); // Output: 0
    }
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int cumulativeSum = 0;

        // Map to store cumulative sums and their frequencies
        Map<Integer, Integer> cumulativeSumFreq = new HashMap<>();
        cumulativeSumFreq.put(0, 1); // Initialize with 0 sum at frequency

        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];

            // Calculate the modulo of the cumulative sum with k
            int modulo = cumulativeSum % k;
            if (modulo < 0) {
                modulo += k; // Ensure the modulo is positive
            }

            // Check if there exists a previous cumulative sum with the same modulo
            if (cumulativeSumFreq.containsKey(modulo)) {
                count += cumulativeSumFreq.get(modulo);
            }

            // Update the cumulative sum frequency
            cumulativeSumFreq.put(modulo, cumulativeSumFreq.getOrDefault(modulo, 0) + 1);
        }

        return count;
    }
}
