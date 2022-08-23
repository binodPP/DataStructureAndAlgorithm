package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumbersDisappearedInAnArray_448 {
    public static void main(String[] args) {
     //int[] nums = {4,3,2,7,8,2,3,1};
        //{4,-3,-2,-7,8,2,3,1}
        int[] nums = {2,3,4,7,11};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
      for(int i=0;i<nums.length;i++){
          int value=Math.abs(nums[i]);
          if(nums[value-1] >0){
             nums[value-1]=-1*nums[value-1];
          }
      }

        for(int j=0; j<nums.length; j++){
            if(nums[j] >0){
                list.add(j+1);
            }
        }

      return list;
    }
}
