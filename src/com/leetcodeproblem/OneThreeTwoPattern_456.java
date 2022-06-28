package com.leetcodeproblem;

import java.util.Stack;

public class OneThreeTwoPattern_456 {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        System.out.println(find132pattern(nums));
        System.out.println(find132pattern2(nums));
        System.out.println(find132pattern3(nums));
    }

    //Pattern1: Time Complexity= O(n), space complexity= O(n)
    public static boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        Stack<Integer> stack = new Stack ();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums [i] < second)
                return true;
            while (!stack.isEmpty() && nums [i] > stack.peek ())
                second = stack.pop ();
            stack.push (nums [i]);
        }
        return false;
    }

    //Pattern2: Time Complexity= O(n * n), space complexity= O(1)
    public static boolean find132pattern2(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        int min=nums[0];
        for(int i=1; i< nums.length; i++){
            for(int j= i+1; j< nums.length; j++){
                    if(nums[i] > min && nums[i] > nums[j] && min < nums[j]){
                        return true;
                    }
                    min=Math.min(nums[i],min);
            }
        }
        return false;
    }

    //Pattern3: Time Complexity= O(n * n* n), space complexity= O(1)
    public static boolean find132pattern3(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        for(int i=0; i< nums.length; i++){
            for(int j= i+1; j< nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[j] > nums[i] && nums[j] > nums[k] && nums[i] < nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
