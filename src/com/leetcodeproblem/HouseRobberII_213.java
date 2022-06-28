package com.leetcodeproblem;

public class HouseRobberII_213 {
    public static void main(String[] args) {
     int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(robPattern2(nums));
    }

    //Pattern2: Time complexity=O(2n)-> O(n), Space complexity= O(1), using optimize dynamic programing
    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        if(nums.length ==2){
            return Math.max(nums[0],nums[1]);
        }

        return Math.max(robHelper(nums,0,nums.length-2),robHelper(nums,1,nums.length-1));
    }

    private static int robHelper(int[] nums, int start, int end){
       int max=0;
       int include=0;
       int exclude=0;

        for(int i=start; i<=end; i++){
           max=Math.max(include,exclude);
           include=exclude+nums[i];
           exclude=max;
        }

        return Math.max(include,exclude);
    }

    //Pattern2: Time complexity=O(2n)-> O(n), Space complexity= O(2n)-> O(n), using dynamic programing
    public static int robPattern2(int[] nums) {
       if(nums.length==1){
           return nums[0];
       }

       if(nums.length ==2){
           return Math.max(nums[0],nums[1]);
       }

       return Math.max(robHelperPattern2(nums,0,nums.length-2),robHelperPattern2(nums,1,nums.length-1));
    }

    private static int robHelperPattern2(int[] nums, int start, int end){
        int[] dp= new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);

        for(int i=start+2; i<=end; i++){
            dp[i]= Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[end];
    }
}
