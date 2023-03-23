package com.leetcodeproblem;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/continuous-subarray-sum/
//https://leetcode.com/problems/continuous-subarray-sum/
public class FindContinuousSubArrayWhoseSumEqualToNumber_523 {

    public static void main(String[] args)
    {
        //findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);

        //findSubArray(new int[]{12, 5, 31, 13, 21, 8}, 49);

        findSubArray(new int[]{10, 40, 3, 20, 8, 15,11}, 31);
    }

    public static void findSubArray(int[] inputArray, int inputNumber) {
        //Initializing sum with the first element of the inputArray
        int left = 0;
        int right = 0;
        int currentSum = 0;

        //Iterating through inputArray starting from second element

        for (int i = 0; i < inputArray.length; i++) { //Adding inputArray[i] to the current 'sum' sum = sum + inputArray[i]; //If sum is greater than inputNumber then following loop is executed until //sum becomes either smaller than or equal to inputNumber while(sum > inputNumber && start <= i-1)
            currentSum = currentSum + inputArray[i];
            if (currentSum == inputNumber) {
                    System.out.println("Continious sub array are between indexex : " + left + " and " + right);
                    break;
                } else if (currentSum < inputNumber) {
                    right++;
                } else if (currentSum > inputNumber) {
                    left++;
                right++;
                    currentSum = currentSum - inputArray[left-1];
                }

            }

        /*for(int j=left; j <= right; j++){
            System.out.println("Subarray are : " + inputArray[j]);
        }*/
    }


    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet=new HashSet();
        int currSum = 0, prevSum=0;
        //when we add prevSum=0 in set it will actually check if currSum is divided by k
        for(int n : nums) {
            currSum += n;
            if(modSet.contains(currSum%k)) {
                return true;
            }
            currSum %=k;
            modSet.add(prevSum);
            prevSum = currSum;
        }
        return false;
    }
}
