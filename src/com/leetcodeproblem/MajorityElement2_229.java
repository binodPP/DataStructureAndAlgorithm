package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/majority-element-ii/
//https://medium.com/@yzhua3/leetcode-majority-element-ii-f411b52b905a
//https://chat.openai.com/c/4e93daa1-58bd-4e9e-b977-a04626351009
//n/3
public class MajorityElement2_229 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementPattern2(nums));
    }

    // Reason behind taking two candiate : The reason for taking two potential candidates instead of three in the Boyer-Moore Majority Vote algorithm for this specific problem is related to the constraint that the elements must appear more than ⌊ n/3 ⌋ times.
    //
    //If you take three potential candidates, there is a chance that none of them appears more than ⌊ n/3 ⌋ times, which could lead to incorrect results. By taking two potential candidates, the algorithm ensures that at least one of them will have a count greater than ⌊ n/3 ⌋ if such elements exist.
    //
    //In the given problem, the maximum number of elements that can appear more than ⌊ n/3 ⌋ times is 2. This is because if there were three elements with counts greater than ⌊ n/3 ⌋, then the total count would exceed n, which is not possible.
    //
    //Therefore, by considering two potential candidates, the algorithm effectively covers all possible cases and ensures correctness while maintaining linear time complexity and constant space complexity.
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

    //Pattern2: Time complexity= O(n), space complexity= O(n)
    public static List<Integer> majorityElementPattern2(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        List<Integer> ans= new ArrayList();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(nums.length/3 < entry.getValue()){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

}
