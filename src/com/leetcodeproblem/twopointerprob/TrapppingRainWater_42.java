package com.leetcodeproblem.twopointerprob;

public class TrapppingRainWater_42 {
    //https://leetcode.com/problems/trapping-rain-water/
    public static void main(String[] args)
    {
        int[] heights = { 4,2,0,3,2,5 };

        System.out.print("The maximum amount of water that can be trapped is " +
                trap(heights));
    }

    //TimeComplexity= O(n), space complexity= O(1)
    public static int trap(int[] heights)
    {
        int left = 0, right = heights.length - 1, water = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                left++;
                maxLeft = Integer.max(maxLeft, heights[left]);
                water += (maxLeft - heights[left]);
            }
            else {
                right--;
                maxRight = Integer.max(maxRight, heights[right]);
                water += (maxRight - heights[right]);
            }
        }

        return water;
    }
}
