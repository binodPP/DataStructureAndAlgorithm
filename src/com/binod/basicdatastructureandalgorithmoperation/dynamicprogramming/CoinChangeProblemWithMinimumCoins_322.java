package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChangeProblemWithMinimumCoins_322 {

    //1 <= coins.length <= 12
    //1 <= coins[i] <= 231 - 1
    //0 <= amount <= 104

    public static void main(String[] args) {

        int[] coins = {1,2,5};

        int sum = 5;

        //System.out.println(CoinChangeProblemWithMinimumCoins.sumOfMinimumCoinsUsingBottomUpApproach(coins, sum));

        System.out.println(CoinChangeProblemWithMinimumCoins_322.minimumWaysCoinsUsingBottomUpApproach(coins, sum));

    }

    public static int sumOfMinimumCoinsUsingBottomUpApproach(int[] coins, int sum){

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
            array[i][0]=0;
        }

        for(int i=0 ;i< numberOfCoins; i++){
            for(int j=1 ; j <= sum; j++){
                int includeCurrentCoins=Integer.MAX_VALUE;
                int excludeCurrentCoins=Integer.MAX_VALUE;
                if(coins[i] <= j){
                    includeCurrentCoins=1+array[i][j-coins[i]];
                }
                if(i > 0){
                    excludeCurrentCoins= array[i-1][j];
                }

                array[i][j] = Math.min(includeCurrentCoins,excludeCurrentCoins);
            }
        }

        return array[numberOfCoins-1][sum] != Integer.MAX_VALUE?array[numberOfCoins-1][sum] : -1;

    }


    public static int minimumWaysCoinsUsingBottomUpApproach(int[] coins, int sum){

        int[] array= new int[sum+1];
        Arrays.fill(array,sum+1);
        array[0]=0;

        for(int i=0 ;i < array.length; i++){
            for(int j=0 ; j < coins.length; j++){
                if(coins[j] <= i){
                    array[i] = Math.min(array[i],1+array[i-coins[j]]);
                }
            }
        }

        return array[sum] > sum ? -1:array[sum];

    }
}
