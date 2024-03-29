package com.leetcodeproblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/missing-number/
/**
 * Created by 609722983 on 2/11/2020.
 */
public class MissingNumberInArray_268 {

    public static void main(String[] args) {
      int[] nums = {2,3,1};
        System.out.println(getMissingNoPattern1(nums));
        System.out.println(getMissingNumberPattern2(nums));
        System.out.println(getMissingNumberPattern3(nums));
    }

    //Method 1, Time Complexity= O(n), space complexity= O(1)
    public static int getMissingNoPattern1(int a[])
    {
        int n= a.length;
        int n_elements_sum = n * (n + 1) / 2;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum =sum+ a[i];
        }

        return n_elements_sum - sum;
    }

    //Method 2: Time Complexity: O(N *log N + log N) , Space Complexity: O(1)
    public static int getMissingNumberPattern2(int[] nums) {
        Arrays.sort(nums);
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

    //Method 3: Time Complexity: O(n) , Space Complexity: O(n)
    public static int getMissingNumberPattern3(int[] arr) {
        int size = arr.length;
        Set set = new HashSet();
        for(int i = 0 ; i < size; i++) {
            set.add(arr[i]);
        }
        for(int i = 0;i <= size; i++) {
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

}
