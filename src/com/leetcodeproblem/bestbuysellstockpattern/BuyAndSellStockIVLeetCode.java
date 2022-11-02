package com.leetcodeproblem.bestbuysellstockpattern;

public class BuyAndSellStockIVLeetCode {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
    Find the maximum profit you can achieve. You may complete at most k transactions.

    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:

    Input: k = 2, prices = [2,4,1]
    Output: 2
    Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
    */

    //TODO: Learn DP then implement below problem
    public static void main(String[] args) {
        int[] prices={3,2,6,5,0,3};
        int k=2;
        System.out.println(new BuyAndSellStockIVLeetCode().maxProfit(k,prices));
    }

    public int maxProfit(int k, int[] prices) {

        return 0;
    }

}
