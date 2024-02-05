package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class FindPeakElementInArray {
    //https://www.techiedelight.com/find-peak-element-array/
    public static void main(String[] args) {
        int[] nums={8, 9, 10, 12, 15};
        int index=findPeakElement(nums,0,nums.length-1);
        int index1=findPeakElement1(nums);
        System.out.println(nums[index]);
        System.out.println(nums[index1]);

    }

    public static int findPeakElement(int[] nums, int left, int right){
        int mid= (left+right)/2;
        if((mid ==0 || nums[mid]>= nums[mid-1]) && (mid==nums.length-1 || nums[mid] >= nums[mid+1])){
            return mid;
        }
        if (mid-1 >0 && nums[mid] < nums[mid-1]){
            return findPeakElement(nums,0,mid-1);
        }
        return findPeakElement(nums,mid+1,right);
    }


    public static int findPeakElement1(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1])
                    && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            }else if (mid - 1 > 0 && nums[mid] < nums[mid - 1]) {
                 right = mid - 1;
            }else {
                left= mid+1;
            }
        }
        return -1;
    }
}
