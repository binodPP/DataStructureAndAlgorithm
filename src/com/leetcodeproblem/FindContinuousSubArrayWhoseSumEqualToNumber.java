package com.leetcodeproblem;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum/

//Non Negative
public class FindContinuousSubArrayWhoseSumEqualToNumber {

    public static void main(String[] args)
    {
        //findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);

        //findSubArray(new int[]{12, 5, 31, 13, 21, 8}, 49);

        findSubArray(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23);
    }

    public static void findSubArray(int[] inputArray, int inputNumber) {
        //Initializing sum with the first element of the inputArray
        int left = 0;
        int right = 0;
        int currentSum = 0;

        //Iterating through inputArray starting from second element

        for (int i = 0; i < inputArray.length; i++) { //Adding inputArray[i] to the current 'sum' sum = sum + inputArray[i];
            // If sum is greater than inputNumber then following loop is executed until
            // sum becomes either smaller than or equal to inputNumber while(sum > inputNumber && start <= i-1)
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
    }
}
