package com.leetcodeproblem;

import java.util.*;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7};
        int k = 2;
        System.out.println(findKthPositive(arr,k));
        System.out.println(findKthPositive2(arr,k));
        System.out.println(findKthPositive3(arr,k));
    }

    //Using Binary Search, Time complexity= O(log n) , space compleFFxity=O(1)
    public static int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length-1, m;
        while (l <= r) {
            m = l + (r-l) / 2;
            if (A[m]-1-m < k)
                l = m + 1;
            else
                r = m-1;
        }
        return l + k;
    }

    //Method 2: Time Complexity: O(n) , Space Complexity: O(1)
    public static int findKthPositive2(int[] arr, int k) {
        for(int i=0;i<arr.length;i++)
        {
            int x=arr[i]-(i+1);
            if(x>=k)
                return i+k;
        }
        return arr.length+k;
    }

    public static int findKthPositive3(int[] arr, int k) {
        int totalLength = arr[arr.length-1]+k;
        Set<Integer> list = new TreeSet<>();
        for (int i=1; i<= totalLength; i++){
            list.add(i);
        }
        for(int i=0;i<arr.length;i++)
        {
            list.remove(arr[i]);
        }

        return new ArrayList<Integer>(list).get(k-1);
    }
}
