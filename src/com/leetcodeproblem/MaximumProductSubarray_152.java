package com.leetcodeproblem;
//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray_152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductPattern2(nums));
        maxProduct3(nums);
        maxProductPattern4(nums);
    }

    //Return max product
    //Pattern-1 using kadanes, time complexity =O(n), space complexity=O(1)
    public static int maxProduct(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int prod1 = nums[0];
        int prod2 = nums[0];
        int max_so_far = nums[0];

        if(nums.length ==1){
            return nums[0];
        }

        for(int i=1;i<nums.length; i++){
            int temp = Math.max(nums[i],Math.max(nums[i] * prod1, nums[i] * prod2));
            prod2= Math.min(nums[i],Math.min(nums[i] * prod1, nums[i] * prod2));
            prod1=temp;
            max_so_far = Math.max(max_so_far,prod1);
        }

        return max_so_far;
    }

    //Return max product
    //Pattern-2 using brute force, time complexity =O(n*n), space complexity=O(1)
    public static int maxProductPattern2(int[] nums) {

        int max_so_far = 0;

        if(nums.length==0){
            return 0;
        }

        if(nums.length ==1){
            return nums[0];
        }

        for(int i=0;i<nums.length; i++){
            int product = 1;
            for(int j=i;j<nums.length; j++){
                product = product * nums[j];

                if(product > max_so_far){
                    max_so_far= product;
                }
            }
        }

        return max_so_far;
    }



    //Return max product with index of subarray
    //Pattern-1 using kadanes, time complexity =O(n), space complexity=O(1)
    public static void maxProduct3(int[] nums) {

        if(nums.length==0){
            System.out.println(0);
        }

        int prod1 = nums[0];
        int prod2 = nums[0];
        int max_so_far = nums[0];

        if(nums.length ==1){
            System.out.println(nums[0]);
        }
        int endIndex=0;
        for(int i=1;i<nums.length; i++){
            int temp = Math.max(nums[i],Math.max(nums[i] * prod1, nums[i] * prod2));
            prod2= Math.min(nums[i],Math.min(nums[i] * prod1, nums[i] * prod2));
            prod1=temp;
            if(prod1 > max_so_far){
                max_so_far = prod1;
                endIndex=i;
            }
        }

        int startIndex = endIndex;
        int temp=max_so_far;
        while (startIndex >= 0){
            temp = temp / nums[startIndex];
            if (temp == 1){
                break;
            }
            startIndex--;
        }
        System.out.println(startIndex+","+endIndex);
       for (int i = startIndex; i<= endIndex ; i++){
           System.out.println(nums[i]);
       }
    }

    //Return max product with index of subarray
    //Pattern-2 using brute force, time complexity =O(n*n), space complexity=O(1)
    public static void maxProductPattern4(int[] nums) {

        int max_so_far = 0;

        if(nums.length==0){
            System.out.println(0);
        }

        if(nums.length ==1){
            System.out.println(nums[0]);
        }

        int endIndex=0;
        for(int i=0;i<nums.length; i++){
            int product = 1;
            for(int j=i;j<nums.length; j++){
                product = product * nums[j];
                if(product > max_so_far){
                    max_so_far= product;
                    endIndex = j;
                }
            }
        }

        int startIndex = endIndex;
        int temp=max_so_far;
        while (startIndex >= 0){
            temp = temp / nums[startIndex];
            if (temp == 1){
                break;
            }
            startIndex--;
        }
        System.out.println(startIndex+","+endIndex);
        for (int i = startIndex; i<= endIndex ; i++){
            System.out.println(nums[i]);
        }
    }
}
