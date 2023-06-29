package com.leetcodeproblem;

import com.sun.codemodel.internal.JForEach;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class K_diffPairsInAnArray_532 {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,4};
        int k = 0;

        System.out.println(findPairs(nums,k));
    }

    //TimeComplexity=O(n), space Complexity=O(n)
    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> integerIntegerMap= new HashMap<>();
        int count=0;
        for(int i=0; i<nums.length; i++){
            integerIntegerMap.put(nums[i],integerIntegerMap.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> entry: integerIntegerMap.entrySet()){
            if(k ==0){
                if(entry.getValue() > 1){
                    count++;
                    System.out.println("["+entry.getKey()+","+entry.getKey()+"]");
                }
            }else {
                if(integerIntegerMap.containsKey(entry.getKey()+k)){
                    count++;
                    System.out.println("["+entry.getKey()+","+(entry.getKey()+k)+"]");
                }
            }
        }
        return count;
    }
}
