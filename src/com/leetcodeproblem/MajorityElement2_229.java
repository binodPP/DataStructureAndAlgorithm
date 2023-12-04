package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
//https://medium.com/@yzhua3/leetcode-majority-element-ii-f411b52b905a
//https://chat.openai.com/c/4e93daa1-58bd-4e9e-b977-a04626351009
//n/3
public class MajorityElement2_229 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result;
    }

}
