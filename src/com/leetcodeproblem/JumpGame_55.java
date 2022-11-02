package com.leetcodeproblem;
//https://leetcode.com/problems/jump-game/
public class JumpGame_55 {
    public static void main(String[] args) {
       int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int reachableIndex=0;
        for(int i =0; i < n ; i ++){
            if(reachableIndex < i){
                return false;
            }
            reachableIndex= Math.max(reachableIndex, i + nums[i]);

        }

        return true;
    }
}
