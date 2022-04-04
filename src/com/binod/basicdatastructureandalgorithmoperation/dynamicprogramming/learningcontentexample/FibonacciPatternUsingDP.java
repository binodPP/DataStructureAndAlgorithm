package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming.learningcontentexample;

public class FibonacciPatternUsingDP {
    int n=4;
    final int max = 10000;
    int dp[]=new int[max];
    public static void main(String[] args) {
        int n=4;
        //pattern-1
        getFibonacciUsingIterativeWay(n);

        //pattern-2
        for(int i=0; i<n; i++) {
            System.out.println("getFibonacciUsingRecursionApproach  " + getFibonacciUsingRecursionApproach(i));
        }

        //Pattern-3
            System.out.println("getFibonacciUsingDPMemoizationORTopUPApproach : " +
                    new FibonacciPatternUsingDP().getFibonacciUsingDPMemoizationORTopUPApproach(n));
    }

    //time complexity=O(n), space complexity=O(1)
    public static void getFibonacciUsingIterativeWay(int n){
        int prev1=1;
        int prev2=0;

        for(int i=1; i<=n; i++){
            System.out.println(prev2);
            int current=prev1+prev2;
            prev2=prev1;
            prev1=current;
        }

    }

    //time complexity=O(2 power n)+O(2 power n)=O(2 power n), space complexity=O(n)
    public static int getFibonacciUsingRecursionApproach(int n){
        if(n==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        return getFibonacciUsingRecursionApproach(n-1)+getFibonacciUsingRecursionApproach(n-2);
    }

    //time complexity=O(n), space complexity=O(n)+O(n)
    public int getFibonacciUsingDPMemoizationORTopUPApproach(int n){
        if(n ==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        if(dp[n] !=0){
            return dp[n];
        }

        return dp[n]=getFibonacciUsingDPMemoizationORTopUPApproach(n-1)+
                    getFibonacciUsingDPMemoizationORTopUPApproach(n-2);

    }
}
