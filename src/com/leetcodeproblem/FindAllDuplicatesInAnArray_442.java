package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicatesInAnArray_442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        //{4,-3,-2,-7,8,2,-3,-1}
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int value=Math.abs(nums[i]);
            if(nums[value-1] >0){
                nums[value-1]=-1*nums[value-1];
            }else {
                list.add(Math.abs(nums[i]));
            }
        }

        return list;
    }
}
