package com.leetcodeproblem;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/sliding-window-maximum/
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int result[] = maxSlidingWindow1(nums,k);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    //Brute Force, Pattern 1, Time Complexity= O(n), space complexity=O(n)
    public static int[] maxSlidingWindowPattern1(int[] nums, int k) {
        int[] result= new int[nums.length-k+1];
        Deque<Integer> deque= new ArrayDeque();
        for(int i=0; i < nums.length ;i++){
            while(deque.size() > 0 && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }
            while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]){
               deque.pollLast();
            }
            deque.offerLast(i);
            if(i-k+1 >= 0){
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    //Brute Force, Pattern 2, Time Complexity= O(n*k), space complexity=O(n)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result= new int[nums.length-k+1];
        int index=0;
        for(int i=0; i < nums.length -k +1 ;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i; j<i+k;j++){
                if(nums[j] > max){
                    max=nums[j];
                }
            }
            result[index++]=max;
        }
        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] result = new int[n - k + 1];

        // Fill leftMax array
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = (i % k == k - 1) ? nums[i] : Math.max(rightMax[i + 1], nums[i]);
        }

        // Fill result array
        for (int i = 0; i <= n - k; i++) {
            result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }

        return result;
    }
}
