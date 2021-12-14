package com.practiceproblem;

public class RotateArrayLeetCode {

    public static void main(String[] args) {
        int k=3;
        int[] nums={3,5,8,1,9,2,6,4,1};

        rotate1(nums,k);
    }

    //time complexity is not good for below pattern
    public static void rotate(int[] nums, int k) {
        int i=0;
        while(i< k){
            for(int j=nums.length-1; j>0; j--){
                int l=nums[j];
                nums[j]=nums[j-1];
                nums[j-1] = l;
            }
            i++;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }

    //pattern 2

    public static void rotate1(int[] nums, int k) {
        int i=0;
        int j=nums.length;
        while(i< k){
            
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }
}
