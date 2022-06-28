package com.leetcodeproblem.twopointerprob;

import java.util.Arrays;

/**
 * Created by 609722983 on 2/25/2020.
 */

/*Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



        Example 1:

        Input: [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Example 2:

        Input: [-7,-3,2,3,11]
        Output: [4,9,9,49,121]


        Note:

        1 <= A.length <= 10000
        -10000 <= A[i] <= 10000
        A is sorted in non-decreasing order.*/


public class SquaresOfSortedArray_977 {
    public static void main(String[] args) {
        int[] array={-4,-1,0,3,10};
        System.out.println("Sorted Squared Array : "+ Arrays.toString(sortedSquaresPattern1(array)));
        System.out.println("Sorted Squared Array : "+ Arrays.toString(sortedSquaresPattern2(array)));
    }

    //TimeComplexity= O(n), space complexity= O(n)
    private static int[] sortedSquaresPattern1(int[] A) {
        int[] outputArray= new int[A.length];
        int left=0,right=A.length-1;
        int current=A.length-1;
        for(int i= A.length-1; i>=0; i--){
            int tempLeft = A[left] * A[left];
            int tempRight = A[right] * A[right];
            if(tempLeft > tempRight){
                outputArray[current]=tempLeft;
                current--;
                left++;
            }else{
                outputArray[current]=tempRight;
                current--;
                right--;
            }
        }
        return outputArray;
    }

    //Pattern2,TimeComplexity= O(n), space complexity= O(n)
    private static int[] sortedSquaresPattern2(int[] A) {
        int[] outputArray= new int[A.length];
        int left=0,right=A.length-1;
        for(int i= A.length-1; i>=0; i--){
            if(Math.abs(A[left])> A[right]){
                outputArray[i]=A[left]*A[left];
                left++;
            }else{
                outputArray[i]=A[right]*A[right];
                right--;
            }
        }
        return outputArray;
    }
}
