package com.leetcodeproblem;

public class StockBuyAndSellLeetCode_121 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static void main(String[] args) {
       int[] prices={7,1,5,3,6,4};
        System.out.println(new StockBuyAndSellLeetCode_121().maxProfit(prices));
    }

    //Option-1 TimeComplexity=O(n), SpaceComplexity=O(1)
    public int maxProfit(int[] prices) {
        int arrayLength= prices.length;
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<arrayLength;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxProfit=Math.max(prices[i]-minPrice,maxProfit);
        }
        return maxProfit;
    }

    //Option-2 TimeComplexity=O(n*n), SpaceComplexity=O(1)
    public int maxProfitOption2(int[] prices) {
        int arrayLength= prices.length;
        int maxProfit=0;
        for(int i=0;i<arrayLength;i++){
            for(int j=i+1; j<arrayLength;j++){
                if(prices[j] > prices[i]){
                    maxProfit=Math.max(prices[j]-prices[i],maxProfit);
                }
            }
        }
        return maxProfit;
    }
}