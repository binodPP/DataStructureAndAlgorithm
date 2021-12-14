package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class TotalNumebrOfWaysForStairs {

    public static void main(String[] args) {
        TotalNumebrOfWaysForStairs stairs = new TotalNumebrOfWaysForStairs();
        int noOfStairsToReach = 6;
        System.out.println(stairs.totalWaysToReachNthStairUsingRecursion(noOfStairsToReach));

        int[] arr = new int[6 + 1];
        System.out.println(stairs.totalWaysToReachNthStairUsingTopDown(arr, 6));

        System.out.println(stairs.totalWaysToReachNthStairUsingBottomUp(6));

        System.out.println(stairs.totalWaysToReachNthStairUsingBottomUpReduceSpaceComplexity(6));

    }

    // Recursive approach
    private int totalWaysToReachNthStairUsingRecursion(int noOfStairs){

        if(noOfStairs == 0){
            return 1;
        }
        if (noOfStairs == 1){
            return 1;
        }
        if (noOfStairs == 2){
            return 2;
        }

        int totalWays=totalWaysToReachNthStairUsingRecursion(noOfStairs-1)
                +totalWaysToReachNthStairUsingRecursion(noOfStairs-2)+
                totalWaysToReachNthStairUsingRecursion(noOfStairs-3);

        return totalWays;

    }

    // Dynamic programming topDown approach
    private int totalWaysToReachNthStairUsingTopDown(int arr[], int noOfStairs){

        if(noOfStairs == 0){
            return 1;
        }
        if (noOfStairs == 1){
            return 1;
        }
        if (noOfStairs == 2){
            return 2;
        }


        if(arr[noOfStairs] == 0) {
            arr[noOfStairs] = totalWaysToReachNthStairUsingTopDown(arr,noOfStairs - 1)
                    + totalWaysToReachNthStairUsingTopDown(arr,noOfStairs - 2) +
                    totalWaysToReachNthStairUsingTopDown(arr,noOfStairs - 3);
        }

        return arr[noOfStairs];

    }


    // Dynamic programming Bottom up approach
    private int totalWaysToReachNthStairUsingBottomUp(int noOfStairs){

        int arr[] = new int[noOfStairs+1];

        arr[0]=1;
        arr[1]=1;
        arr[2]=2;

        for(int i = 3 ; i <= noOfStairs; i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr[noOfStairs];
    }

    // Dynamic programming Better version of Bottom up approach in terms of space complexity
    private int totalWaysToReachNthStairUsingBottomUpReduceSpaceComplexity(int noOfStairs){

        int a=1;
        int b=1;
        int c=2;
        int d;

        for(int i = 3 ; i <= noOfStairs; i++){
            d=c+b+a;
            a=b;
            b=c;
            c=d;
        }
        return c;
    }

}
