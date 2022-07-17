package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class SearchElementInCircularlySortedArray {

    //https://www.techiedelight.com/search-element-circular-sorted-array/
    public static void main(String[] args) {
        int[] nums = {8, 9, 10, 2, 5, 6};
        int target=5;
        System.out.println(searchCircularArray(nums,target));
    }

    public static int searchCircularArray(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        while(left<=right){

            int mid= (left+right)/2;
            if(target == nums[mid]){
                return mid;
            }

            if(nums[mid] <= nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
