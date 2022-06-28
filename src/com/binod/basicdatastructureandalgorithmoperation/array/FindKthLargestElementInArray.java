package com.binod.basicdatastructureandalgorithmoperation.array;



import com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm.QuickSortAlgorithm_912;

import java.util.PriorityQueue;

public class FindKthLargestElementInArray {
    public static void main(String[] args) {
        int[] numbers = {30, 20,50,10,25,45,42,41};;
        int k =4;
        System.out.println(findKthLargest(numbers,k));

        QuickSortAlgorithm_912.sortAlgorithm(numbers,0,numbers.length-1);

        System.out.println(numbers[numbers.length-k]);;
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
}
