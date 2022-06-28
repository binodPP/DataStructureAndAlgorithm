package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray_697 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }

    //TimeComplexity= O(2n)-> O(n), space complexity= O(3n)-> O(n)
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> countMap= new HashMap<>();
        Map<Integer,Integer> leftMap= new HashMap<>();
        Map<Integer,Integer> rightMap= new HashMap<>();

        int degree=0;

        for(int i=0; i< nums.length; i++){
            int x= nums[i];

            leftMap.putIfAbsent(x,i);
            rightMap.put(x,i);
            countMap.put(x,countMap.getOrDefault(x,0)+1);

            degree=Math.max(degree, countMap.get(x));
        }

        int ans=nums.length;

        for (Integer countMapKey: countMap.keySet()) {
            if(countMap.get(countMapKey) == degree){
                ans = Math.min(ans,rightMap.get(countMapKey)- leftMap.get(countMapKey)+1);
            }
        }
       return ans;
    }
}
