package com.leetcodeproblem;

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/
//https://chat.openai.com/c/4e93daa1-58bd-4e9e-b977-a04626351009
public class MinimumDominoRotationsForEqualRow_1007 {
    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2}, bottoms = {5,2,6,2,3,2};
        //int[] tops = {3,5,1,2,3}, bottoms = {3,6,3,3,4};
        System.out.println(minDominoRotations(tops,bottoms));
    }


    //Explanation:
    //
    //We define a function minDominoRotations that takes two arrays tops and bottoms as input.
    //
    //We calculate the length of the arrays and initialize a variable result to store the minimum rotations required.
    //
    //We call the numRotations function twice with tops[0] and bottoms[0] as the target value. This is because we want to find the minimum rotations needed when the first domino in the row has the same value on the top or bottom.
    //
    //In the numRotations function, we calculate the number of rotations needed to make all dominoes match the target value. We initialize rotationsTop and rotationsBottom to count the rotations needed for tops and bottoms, respectively.
    //
    //We iterate through the dominoes and check if the current domino doesn't have the target value on either the top or the bottom. If that's the case, it's not possible to make all values the same, so we return Integer.MAX_VALUE.
    //
    //If the current domino has a different value on the top, we increment rotationsTop. If it's different on the bottom, we increment rotationsBottom.
    //
    //Finally, we return the minimum of rotationsTop and rotationsBottom as the result.
    //
    //If result is still Integer.MAX_VALUE, it means it's not possible to make all values the same, so we return -1. Otherwise, we return the minimum number of rotations needed.

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int result = Math.min(
                numRotations(tops[0], tops, bottoms, n),
                numRotations(bottoms[0], tops, bottoms, n)
        );

        return result == Integer.MAX_VALUE? -1: result;
    }

    private static int numRotations(int target, int[] tops, int[] bottoms, int n) {
        int rotationsTop = 0;
        int rotationsBottom = 0;

        for (int i = 0; i < n; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return Integer.MAX_VALUE; // It's not possible to make all values the same.
            } else if (tops[i] != target) {
                rotationsTop++;
            } else if (bottoms[i] != target) {
                rotationsBottom++;
            }
        }

        return Math.min(rotationsTop, rotationsBottom);
    }

}
