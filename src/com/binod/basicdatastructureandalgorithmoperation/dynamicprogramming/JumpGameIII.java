package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class JumpGameIII {

    //1306. Jump Game III

    //Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
    //
    //Notice that you can not jump outside of the array at any time.
    //
    //
    //
    //Example 1:
    //
    //Input: arr = [4,2,3,0,3,1,2], start = 5
    //Output: true
    //Explanation:
    //All possible ways to reach at index 3 with value 0 are:
    //index 5 -> index 4 -> index 1 -> index 3
    //index 5 -> index 6 -> index 4 -> index 1 -> index 3

    public static void main(String[] args) {
        int[] array = {3,0,2,1,2};
        int start=2;
        System.out.println(canReach(array,start));
    }

    private static boolean canReach(int[] array, int startIndex){
        int[] indexVisited = new int[array.length];
           return dfs(array,startIndex, indexVisited);
    }

    //Option -1
    /*private static boolean dfs(int[] arr,int start, int[] indexVisited) {
        int n = arr.length;
        boolean foundValue=false;
        if (start < 0 || start >= n) {
            return false;
        }

        if(arr[start] == 0){
            return true;
        }

        if(indexVisited[start] == 1){
            return false;
        }else {
            indexVisited[start]=1;
            if (start + arr[start] < n) {
                foundValue = dfs(arr, start + arr[start],indexVisited);
            }

            if (foundValue) {
                return foundValue;
            }
            if (start - arr[start] >= 0) {
                foundValue = dfs(arr, start - arr[start], indexVisited);
            }
            return foundValue;
        }
}*/

    //Option -2
    private static boolean dfs(int[] arr,int start, int[] indexVisited){
        int n= arr.length;
        //int[] indexVisited = new int[n];
        if(start < 0 || start >= n){
            return false;
        }

        if(arr[start] == 0){
            return true;
        }

        if(indexVisited[start] == 1){
            return false;
        }else {
            //mark visited index with value 1
            indexVisited[start] = 1;
            return dfs(arr,start+arr[start],indexVisited) || dfs(arr,start - arr[start],indexVisited);
        }

    }
}
