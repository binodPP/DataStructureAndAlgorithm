package com.binod.basicdatastructureandalgorithmoperation.array;



import com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm.QuickSortAlgorithm_912;

import java.util.PriorityQueue;

public class FindKthLargestElementInArray {
    public static void main(String[] args) {
        int[] numbers = {30, 20,50,10,25,45,42,41};;
        int k =4;
        System.out.println(findKthLargest(numbers,k));

        System.out.println(findKthLargest1(numbers,k));

        QuickSortAlgorithm_912.sortAlgorithm(numbers,0,numbers.length-1);

        System.out.println(numbers[numbers.length-k]);


    }

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

    public static int findKthLargest1(int[] nums, int k) {
        int first=nums[0];
        int sec=nums[0];
        int third=nums[0];
        int fourth= nums[0];
        for(int i=1; i< nums.length ; i++){
            if(nums[i] > first){
                sec = first;
                first = nums[i];
            }else if(nums[i] > sec){
                sec = nums[i];
            }else if(nums[i] > third){
                third = nums[i];
            }else if(nums[i] > fourth){
                fourth = nums[i];
            }

        }

        return fourth;
    }
}
