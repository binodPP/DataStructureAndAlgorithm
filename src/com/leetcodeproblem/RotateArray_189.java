package com.leetcodeproblem;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] result = rotateOptimiseOne(nums,k);
        //rotate(nums,k);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    //Time complexity=O(3n)->O(n), Space complexity=O(1)
    public static int[] rotateOptimiseOne(int[] nums, int k) {
         k= k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return nums;
        }

    private static void reverse(int[] nums,int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    //Pattern-2
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

    }
}
