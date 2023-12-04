package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
//Negative integer also
public class SubarraySumEqualsK_560 {

    public static void main(String[] args) {
        SubarraySumEqualsK_560 subarraySumEqualsK = new SubarraySumEqualsK_560();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySumEqualsK.subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySumEqualsK.subarraySum(nums2, k2)); // Output: 2
    }

    //1,1,1   k =2
    //1,2,3   k =3
    public int subarraySum(int[] inputArray, int k){
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        int count = 0;
        int currentSum = 0;
        integerIntegerMap.put(0,1); // Initialize with 0 sum and frequency
        for(int i=0; i< inputArray.length; i++){
            currentSum = currentSum + inputArray[i];
            if(integerIntegerMap.containsKey(currentSum - k)){
                count = count + integerIntegerMap.get(currentSum - k);
            }
            integerIntegerMap.put(currentSum, integerIntegerMap.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}
