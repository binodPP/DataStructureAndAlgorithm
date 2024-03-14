package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/majority-element/
//Elements appears more then n/2
public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,2,3,3,3};
        System.out.println(majorityElementPattern1(nums));
        System.out.println(majorityElementPattern2(nums));
    }

    //Pattern1: Time complexity= O(n), space complexity= O(1)
    public static int majorityElementPattern1(int[] nums) {
        int count=0;
        int majorityElement=0;

        for(int i=0; i<nums.length; i++){
           if(count == 0){
               majorityElement = nums[i];
               count = 1;
           }else if(nums[i] == majorityElement){
               count++;
           }else {
               count--;
           }
        }
       /* This is extra code if majority does not guarantee to be
       present but for above leetcode they are saying it will present but for use case
       side i have added below code

        // Check if the candidate is indeed the majority element by counting its occurrences
        int majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }

        // If the candidate appears more than n/2 times, return it as the majority element
        if (majorityCount > nums.length / 2) {
            return majorityElement;
        } else {
            // If the majority element doesn't exist, you can return a special value or throw an exception
            // For simplicity, let's return -1 as a special value
            return -1;
        }

        */

        return majorityElement;
    }

    //Pattern2: Time complexity= O(n), space complexity= O(n)
    public static int majorityElementPattern2(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        int ans=0;

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(nums.length/2 < entry.getValue()){
                ans=entry.getKey();
            }
        }
        return ans;
    }
}
