package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class MinCostClimbingStairs_746 {

    // 746. Min Cost Climbing Stairs:- https://leetcode.com/problems/min-cost-climbing-stairs/

    public static void main(String[] args) {
        //int[] cost = {10,15,20};
        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(MinCostClimbingStairs_746.minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {

        //option 1
        int n=cost.length;
        int arr[] = new int[n+1];

        //Base condition
        arr[0]=0;
        arr[1]=0;

        for(int i = 2 ; i <= n; i++){
            arr[i]=Math.min(arr[i-1]+cost[i-1],arr[i-2]+cost[i-2]);
        }
        return arr[n];

    }

}

