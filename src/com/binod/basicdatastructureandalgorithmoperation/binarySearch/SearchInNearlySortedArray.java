package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class SearchInNearlySortedArray {
    //https://www.techiedelight.com/search-nearly-sorted-array-ologn-time/
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4, 7, 6, 8, 9};
        int target = 5;
        System.out.println(searchElement(nums,target));
    }

    //TimeComplexity= O(log(n)), spaceComplexity= O(1)
    public static int searchElement(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;

        while(left<=right){

            int mid= (left+right)/2;

            if(target == nums[mid]){
                return mid;
            }else if (mid-1 >= left && nums[mid-1] == target){
                return mid-1;
            }else if(mid+1 <= right && nums[mid+1] == target){
                return mid+1;
            }else if(target < nums[mid]){
                right=mid-2;
            }else {
                left=mid+2;
            }
        }

        return -1;
    }
}
