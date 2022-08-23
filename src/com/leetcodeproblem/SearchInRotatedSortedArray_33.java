package com.leetcodeproblem;

public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }

    //Modified Binary search algo , same question in binary search package SearchElementInCircularlySortedArray
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<= right){
            int mid=(right+left)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] <= nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {
                if(nums[left] <= target && nums[mid] > target){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
