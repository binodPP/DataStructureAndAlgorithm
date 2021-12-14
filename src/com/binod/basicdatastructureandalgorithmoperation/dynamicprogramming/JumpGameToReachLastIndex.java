package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class JumpGameToReachLastIndex {

    // 55.Jump Game:- https://leetcode.com/problems/jump-game/
    // Reference from - https://www.youtube.com/watch?v=muDPTDrpS28
    public static void main(String[] args) {
        int[] array = {2,1,2,1,0,4};

        System.out.println(JumpGameToReachLastIndex.canJumpToLastIndex(array));
    }

    private static boolean canJumpToLastIndex(int[] array){
        int n = array.length;
        int reachableIndex=0;
        for(int i =0; i < n; i ++){
            if(reachableIndex < i){
                return false;
            }

            reachableIndex= Math.max(reachableIndex, i + array[i]);
        }
        return true;
    }

}
