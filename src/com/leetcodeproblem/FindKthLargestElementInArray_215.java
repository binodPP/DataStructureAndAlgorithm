package com.leetcodeproblem;



import com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm.QuickSortAlgorithm_912;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class FindKthLargestElementInArray_215 {
    public static void main(String[] args) {
        int[] numbers = {3,2,1,5,6,4};;
        int k =4;
        System.out.println(findKthLargest(numbers,k));

        System.out.println(findKthLargest1(numbers,k));

        //TC: O(N LOG(N)), SC:O(1)
        QuickSortAlgorithm_912.sortAlgorithm(numbers,0,numbers.length-1);

        System.out.println(numbers[numbers.length-k]);


    }

    //TC: O(N), SC:O(N)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    //TC: O(N), SC:O(1)
    public static int findKthLargest1(int[] nums, int k) {
        int first=nums[0];
        int sec=nums[0];
        int third=nums[0];
        int fourth= nums[0];
        for(int i=1; i< nums.length ; i++){
            if(nums[i] > first){
                fourth = third;
                third=sec;
                sec = first;
                first = nums[i];
            }else if(nums[i] > sec){
                fourth = third;
                third = sec;
                sec = nums[i];
            }else if(nums[i] > third){
                fourth = third;
                third = nums[i];
            }else if(nums[i] > fourth){
                fourth = nums[i];
            }

        }

        return fourth;
    }
}
