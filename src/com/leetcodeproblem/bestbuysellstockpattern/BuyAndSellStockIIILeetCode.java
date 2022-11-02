package com.leetcodeproblem.bestbuysellstockpattern;

public class BuyAndSellStockIIILeetCode {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Find the maximum profit you can achieve. You may complete at most two transactions.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:

    Input: prices = [3,3,5,0,0,3,1,4]
    Output: 6
    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    */

    public static void main(String[] args) {
        int[] prices={1,2,3,4,5};
        System.out.println(new BuyAndSellStockIIILeetCode().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int firstBuyTxn=Integer.MAX_VALUE;
        int secondBuyTxn=Integer.MAX_VALUE;
        int firstSellTxn=0;
        int secondSellTxn=0;

        for(int i=0; i<prices.length;i++){
            firstBuyTxn=Math.min(firstBuyTxn,prices[i]);
            firstSellTxn=Math.max(firstSellTxn,prices[i]-firstBuyTxn);

            secondBuyTxn=Math.min(secondBuyTxn,prices[i]-firstSellTxn);
            secondSellTxn=Math.max(secondSellTxn,prices[i]-secondBuyTxn);

        }

        return secondSellTxn;
    }
}
