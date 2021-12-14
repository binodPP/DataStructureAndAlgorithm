package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class MinimumJumpToReachTheLastIndex {
    //45. Jump Game II- https://leetcode.com/problems/jump-game-ii/

    public static void main(String[] args) {
        int[] array = {2,3,1,1,4};

        System.out.println(MinimumJumpToReachTheLastIndex.minimumJumpToLastIndex(array));
    }

    private static int minimumJumpToLastIndex(int[] array){
        int n = array.length;
        int reachableIndex=0;
        int minimumJumps=0;
        int currentReachedIndex=0;
        for(int i =0; i < n-1; i ++){
            reachableIndex= Math.max(reachableIndex, i + array[i]);

            if(i >= currentReachedIndex){
                minimumJumps++;
                currentReachedIndex = reachableIndex;
            }
        }
        return minimumJumps;
    }
}
