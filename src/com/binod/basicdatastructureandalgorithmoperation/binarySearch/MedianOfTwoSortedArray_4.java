package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class MedianOfTwoSortedArray_4 {

    //TimeComplexity=O(log(m+n)), space complexity=O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int num1Length=nums1.length;
        int num2Lenght=nums2.length;

        double median = 0;


        int low=0;
        int high=num1Length;

        while(low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = ((num1Length + num2Lenght + 1) / 2) - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = partition1 == num1Length ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = partition2 == num2Lenght ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {

                if ((num1Length + num2Lenght) % 2 == 0) {
                    median=((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                    return median;
                } else {
                    median=(Math.max(maxLeft1, maxLeft2));
                    return median;
                }
            } else if (maxLeft1 >= minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
      return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println("Median of two sorted arrays : " + MedianOfTwoSortedArray_4.findMedianSortedArrays(nums1,nums2));
    }
}
