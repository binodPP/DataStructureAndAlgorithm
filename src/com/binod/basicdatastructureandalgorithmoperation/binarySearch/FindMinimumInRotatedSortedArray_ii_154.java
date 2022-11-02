package com.binod.basicdatastructureandalgorithmoperation.binarySearch;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//NOTE: it contains duplicate element
public class FindMinimumInRotatedSortedArray_ii_154 {
    public static void main(String[] args) {
        int[] nums ={2,2,2,0,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){

            //handle cases like [3, 1, 3]
            while(nums[left]==nums[right] && left!=right){
                left++;
            }

            if(nums[left]<=nums[right]){
                return nums[left];
            }

            int mid =left+ (right-left)/2;
            if(nums[mid]>=nums[left]){
                left=mid+1;
            }else{
                //Handle case [3,1,1] because if we put right = mid-1,
                // then this case will fail so we need to use right = mid
                right=mid;
            }
        }

        return -1;
    }
}
