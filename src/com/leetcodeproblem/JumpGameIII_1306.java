package com.leetcodeproblem;

import java.util.HashSet;

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



    public boolean canReach_patter2(int[] arr, int start) {
        // Create a set to keep track of visited indices.
        HashSet<Integer> visited = new HashSet<>();
        return dfs_1(arr, start, visited);
    }

    private boolean dfs_1(int[] arr, int index, HashSet<Integer> visited) {
        // Base case: If the index is out of bounds or has been visited, return false.
        if (index < 0 || index >= arr.length || visited.contains(index)) {
            return false;
        }

        // If we reach an element with a value of 0, return true.
        if (arr[index] == 0) {
            return true;
        }

        // Mark the current index as visited.
        visited.add(index);

        // Try jumping to the right and left neighbors.
        if (dfs_1(arr, index + arr[index], visited)) {
            return true;
        }
        if (dfs_1(arr, index - arr[index], visited)) {
            return true;
        }

        // If no path to zero is found from this index, mark it as unvisited and return false.
        visited.remove(index);
        return false;
    }

    /*public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        int start1 = 5;
        System.out.println(solution.canReach(arr1, start1)); // true

        int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
        int start2 = 0;
        System.out.println(solution.canReach(arr2, start2)); // true

        int[] arr3 = {3, 0, 2, 1, 2};
        int start3 = 2;
        System.out.println(solution.canReach(arr3, start3)); // false
    }*/
}

