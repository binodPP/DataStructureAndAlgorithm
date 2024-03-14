package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class FindSmallestMissingElementFromSortedArray {
    //https://www.techiedelight.com/find-smallest-missing-element-sorted-array/
    public static void main(String[] args) {
        //int[] nums = {0,1, 2, 3, 5, 6};
        int[] nums = {1, 2, 3, 4,5};
        int left=0;
        int right=nums.length-1;

        System.out.println(findSmallestMissing(nums,left,right));
        System.out.println(findSmallestMissing1(nums));

    }

    //TimeComplexity = O(log(n)), spaceComplexity= O(1)
    public static int findSmallestMissing(int[] nums, int left, int right){
        if(left > right){
            return left;
        }

        int mid = (left + right)/2;

        if (nums[mid] == mid){
            return findSmallestMissing(nums,mid+1,right);
        }else {
            return findSmallestMissing(nums,left,mid-1);
        }
    }

    //TimeComplexity = O(log(n)), spaceComplexity= O(1)
    public static int findSmallestMissing1(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                    right = mid - 1;
                }
            }

        return left;
    }

}
