package com.leetcodeproblem;

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;
        System.out.println(search(nums,target));
        System.out.println(searchRecursion(nums,0,nums.length-1,target));
    }

    //iterative way
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<= right){
            int mid=(right+left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
       return -1;
    }

    //Recursion way
    public static int searchRecursion(int[] nums, int left, int right, int target) {
        if(right < left){
            return -1;
        }
        int mid=(right+left)/2;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return searchRecursion(nums,mid+1, right,target );
        }
            return searchRecursion(nums,left,mid-1,target);
    }
}
