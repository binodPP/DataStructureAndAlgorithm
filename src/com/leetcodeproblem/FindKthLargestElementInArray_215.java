package com.leetcodeproblem;



import com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm.QuickSortAlgorithm_912;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class FindKthLargestElementInArray_215 {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 8, 4, 2, 7, 5};;
        int k =4;
        System.out.println(findKthLargest(numbers,k));

        System.out.println(findKthLargest1(numbers,k));

        //TC: O(N LOG(N)), SC:O(1)
        QuickSortAlgorithm_912.sortAlgorithm(numbers,0,numbers.length-1);

        System.out.println(numbers[numbers.length-k]);


    }

    //Building the initial PriorityQueue of size k: O(k * log(k)). Each insertion operation (offer()) takes O(log(k)) time, and there are k elements.
    //Iterating through the array nums: O(n), where n is the length of the array.
    //Within the loop:
    //Insertion operation (offer()): O(log(k)) if the size of the PriorityQueue is less than k.
    //Polling operation (poll()): O(log(k)) if the size of the PriorityQueue exceeds k.
    //Overall time complexity: O(n * log(k)).
    //Space Complexity:
    //
    //Space required for the PriorityQueue: O(k). The PriorityQueue stores at most k elements.
    //Additional space used for variables and the input array nums: O(n + k).
    //Overall space complexity: O(n + k).
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
           // q.offer(i);
            System.out.println("$$$$$$$$$"+q.offer(i));
            if(q.size()>k){
                //q.poll();
                System.out.println("#######"+q.poll());
            }
        }

        return q.peek();
    }

    //TC: O(N), SC:O(1)
    public static int findKthLargest1(int[] nums, int k) {
        int first=nums[0];
        int sec=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        int fourth= Integer.MIN_VALUE;
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
