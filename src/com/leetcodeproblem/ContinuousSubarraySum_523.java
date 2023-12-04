package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/continuous-subarray-sum/description/
public class ContinuousSubarraySum_523 {

    public static void main(String[] args) {
        ContinuousSubarraySum_523 continuousSubarraySum_523 = new ContinuousSubarraySum_523();

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(continuousSubarraySum_523.checkSubarraySum(nums1, k1)); // Output: true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(continuousSubarraySum_523.checkSubarraySum(nums2, k2)); // Output: true

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(continuousSubarraySum_523.checkSubarraySum(nums3, k3)); // Output: false
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        Map<Integer, Integer> cumulativeSumsModK = new HashMap<>();
        cumulativeSumsModK.put(0, -1); // Initialize with 0 mod k at index -1
        int cumulativeSum = 0;

        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            if (k != 0) {
                cumulativeSum %= k;
            }

            if (cumulativeSumsModK.containsKey(cumulativeSum)) {
                if (i - cumulativeSumsModK.get(cumulativeSum) > 1) {
                    return true;
                }
            } else {
                cumulativeSumsModK.put(cumulativeSum, i);
            }
        }

        return false;
    }
}
