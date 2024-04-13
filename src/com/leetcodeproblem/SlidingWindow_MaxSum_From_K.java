package com.leetcodeproblem;

public class SlidingWindow_MaxSum_From_K {

    public static void main(String[] args) {
        /*
        Given an array of integers of size ‘n’, calculate the maximum sum of ‘k’ consecutive elements in the array.
        Input  : arr[] = {100, 200, 300, 400}, k = 2
        Output : 700
        Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 Output : 39
        Input  : arr[] = {2, 3}, k = 3
        Output : Invalid

         */
        int arr[] = {100, 200, 300, 400};
        int n=2;
        System.out.println(maxSlidingWindow_1(arr, n));
        System.out.println(maxSlidingWindow_2(arr, n));
    }

    public static int maxSlidingWindow_1(int[] nums, int k) {
        int result=0;
        for(int i=0; i < nums.length -k +1 ;i++){
            int max=0;
            for(int j=i; j<i+k;j++){
                max= max + nums[j];
            }
            if(max > result){
                result = max;
            }
        }
        return result;
    }

    public static int maxSlidingWindow_2(int[] nums, int k) {
        int result=0;
        int i=0;
        while (i<nums.length){
            int max=0;
            for(int j=i; j<i+k && j< nums.length;j++){
                max= max + nums[j];
            }
            if(max > result){
                result = max;
            }
            i++;
        }
        return result;
    }
}
