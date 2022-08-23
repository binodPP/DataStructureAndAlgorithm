package com.binod.basicdatastructureandalgorithmoperation.array;

//https://leetcode.com/problems/longest-turbulent-subarray/
/**
 * Created by 609722983 on 2/25/2020.
 */

       /* A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

        For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
        OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
        That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

        Return the length of a maximum size turbulent subarray of A.

        Example 1:

        Input: [9,4,2,10,7,8,8,1,9]
        Output: 5
        Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

        sol:
       1. k>=2
          =====
          a[k-2]a[k-1]<a[k]


        */

public class LongestTurbulentSubarray_978 {
    public static void main(String[] args) {
        //int[] array={9,4,2,10,7,8,8,1,9};
        //int[] array={0,8,45,88,48,68,28,55,17,24};
        //int[] array={0,8,45,88,48,68,28,55,17,24};
        int[] array={100};
        int longestSubArrayLength=maxTurbulenceSize(array);
        System.out.println("The length of a maximum size turbulent subarray is : " + longestSubArrayLength);
    }

    private static int maxTurbulenceSize(int[] arrayList){
        int len=0,maxLength=0;
        for(int k=0; k<arrayList.length;k++){
            if(k >=2 && ((arrayList[k-2] < arrayList[k-1] && arrayList[k-1] > arrayList[k]) ||
                    (arrayList[k-2] > arrayList[k-1] && arrayList[k-1] < arrayList[k]))){
                len++;
            }else if(k>=1 && (arrayList[k] != arrayList[k-1])){
                  len++;
              }else {
                  len=1;
              }

              maxLength=Math.max(len,maxLength);
            }
            return maxLength;
        }

    /*private static int maxTurbulenceSize(int[] arrayList){
        int len=0,maxLength=0;
        for(int k=0; k<arrayList.length-1;k++){
            if(k>=2 && ((arrayList[k-2] < arrayList[k-1] && arrayList[k-1] > arrayList[k]) ||
                    (arrayList[k-2] > arrayList[k-1] && arrayList[k-1] <arrayList[k])))

            maxLength=Math.max(len,maxLength);
        }
        return maxLength;
    }*/
}
