package com.leetcodeproblem;
//https://leetcode.com/problems/jump-game-iii/
public class JumpGameIII_1306 {
    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr, start));
        System.out.println(canReachPattern2(arr,start));
    }

    //pattern-1, Time complexity= O(n), Space complexity=O(1)
    public static boolean canReach(int[] arr, int start) {

        if (start >= 0 && start < arr.length && arr[start] >= 0 && arr[start] <= arr.length) {

            if (arr[start] == 0) {
                return true;
            }

            //Resolve stackoverflow
            arr[start] = -arr[start];

            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);

        }
        return false;
    }

    //Pattern2, timecomplexity= O(n), space complexity=O(n)
    public static boolean canReachPattern2(int[] arr, int start) {

        int[] indexVisited = new int[arr.length];
        return dfs(arr, start, indexVisited);
    }

    private static boolean dfs(int[] arr, int start, int[] indexVisited) {
        int n = arr.length;
        boolean foundValue = false;
        if (start < 0 || start >= n) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        if (indexVisited[start] == -1) {
            return false;
        } else {
            indexVisited[start] = -1;
            if (start + arr[start] < n) {
                foundValue = dfs(arr, start + arr[start], indexVisited);
            }

            if (foundValue) {
                return foundValue;
            }
            if (start - arr[start] >= 0) {
                foundValue = dfs(arr, start - arr[start], indexVisited);
            }
            return foundValue;
        }
    }
}
