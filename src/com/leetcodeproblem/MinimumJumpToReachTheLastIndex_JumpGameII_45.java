package com.leetcodeproblem;

import java.util.Arrays;

public class MinimumJumpToReachTheLastIndex_JumpGameII_45 {
    //45. Jump Game II- https://leetcode.com/problems/jump-game-ii/

    public static void main(String[] args) {
        int[] array = {2,1,1,1,4};

        System.out.println(MinimumJumpToReachTheLastIndex_JumpGameII_45.minimumJumpToLastIndex(array));
    }

    //To find the minimum number of jumps to reach the last element of the given array
    // without using dynamic programming, we can utilize a greedy approach.
    // We can keep track of the current farthest reachable index and the
    // current end of the reachable range. As we iterate through the array,
    // if we reach the end of the current reachable range, we make a jump to
    // the farthest index we can reach and update the new reachable range.
    // We continue this process until we reach the last index.
    private static int minimumJumpToLastIndex(int[] array){
        int n = array.length;
        int reachableIndex=0;
        int minimumJumps=0;
        int currentReachedIndex=0;
        //always go till before last element which is < n-1 other wise it i will take reachbale
        // index of last and also with below if condition it will increase minimum jups which is wrong
        for(int i =0; i < n-1; i ++){
            reachableIndex= Math.max(reachableIndex, i + array[i]);

            if(i == currentReachedIndex){
                minimumJumps++;
                currentReachedIndex = reachableIndex;
            }
        }
        return minimumJumps;
    }

    //Using DP
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the minimum number of jumps needed to reach index i

        // Initialize dp array with maximum values
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // It takes 0 jumps to reach the first index

        for (int i = 1; i < n; i++) {
            // Iterate through all the previous indices (j) and check if we can reach index i from index j
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    // If we can reach index i from index j, update the minimum jumps needed to reach index i
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1]; // Minimum jumps needed to reach the last index
    }


}
