package com.leetcodeproblem;

import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int result[] = maxSlidingWindowPattern1(nums,k);
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
}
