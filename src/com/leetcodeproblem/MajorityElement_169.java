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
           }

           if(nums[i] == majorityElement){
               count++;
           }else {
               count--;
           }
        }
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
