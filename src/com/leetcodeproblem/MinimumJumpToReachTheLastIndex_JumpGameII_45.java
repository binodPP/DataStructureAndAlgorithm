package com.leetcodeproblem;

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
}
