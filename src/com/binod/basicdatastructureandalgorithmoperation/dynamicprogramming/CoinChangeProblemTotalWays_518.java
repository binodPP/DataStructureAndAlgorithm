package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

//https://leetcode.com/problems/coin-change-2/
public class CoinChangeProblemTotalWays_518 {

    //You can assume that
    //0 <= sum <= 5000
    //1 <= coins <= 5000
    //the number of coins is less than 500
    //the answer is guaranteed to fit into signed 32-bit integer

    public static void main(String[] args) {

        int[] coins = {1, 2, 3};

        int sum = 5;

        System.out.println(CoinChangeProblemTotalWays_518.totalWaysOfCoinChangeUsingBottomUpApproach(coins, sum));

    }

    public static int totalWaysOfCoinChangeUsingBottomUpApproach(int[] coins, int sum){

        if(sum==0){
            return 1;
        }

        if(sum < 0){
            return 0;
        }

        int numberOfCoins= coins.length;

        if(numberOfCoins <=0 && sum >=1){
            return 0;
        }

        int[][] array= new int[numberOfCoins][sum+1];

        for(int i =0; i< numberOfCoins ; i++){
            array[i][0]=1;
        }

        for(int i=0 ;i< numberOfCoins; i++){
            for(int j=1 ; j <= sum; j++){
                int includeCurrentCoins=0;
                int excludeCurrentCoins=0;
                if(i > 0){
                    excludeCurrentCoins= array[i-1][j];
                }
                if(coins[i] <= j){
                    includeCurrentCoins=array[i][j-coins[i]];
                }

                array[i][j] = includeCurrentCoins + excludeCurrentCoins;
            }
        }

        return array[numberOfCoins-1][sum];

    }
}
