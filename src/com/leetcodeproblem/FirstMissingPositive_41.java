package com.leetcodeproblem;
//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        //int[] nums={1};
        //System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositivePattern2(nums));

    }

    //Pattern1: Time Comlexity = O(n), space complexity= O(1)
    public static int firstMissingPositive(int[] nums) {
        int len=nums.length;
       if(len == 0){
           return 1;
       }

       int i=0;
       while (i<len){
           if(nums[i] > len || nums[i] <=0){
               i++;
           }else if(nums[nums[i]-1] == nums[i]){
               i++;
           }else {
               int temp= nums[nums[i]-1];
               nums[nums[i]-1]=nums[i];
               nums[i] = temp;
           }
       }

       for(int j=0; j< len; j++){
           if(nums[j] !=j+1){
               return j+1;
           }
       }

       return len+1;
    }

    //Pattern2: Time Comlexity = O(n * n), space complexity= O(1)
    public static int firstMissingPositivePattern2(int[] nums) {
        int len=nums.length;
        if(len == 0){
            return 1;
        }

        for(int i=1; i<= len; i++){
            boolean missingFlag=true;
            for(int j=0; j< len; j++){
                if(nums[j] == i ){
                    missingFlag=false;
                    break;
                }
            }

            if(missingFlag == true){
                return i;
            }
        }

        return 0;
    }
}
