package com.leetcodeproblem;

public class MinimumSumSubarraysOfSizeK {

    public static void main(String[] args) {
        int[] array={1,4,0,3,5,2,6,1};
        int k=4;
        System.out.println(getMinSum(array,k));
    }

    public static int getMinSum(int[] array, int k){
        int min=Integer.MAX_VALUE;
        for(int i=0; i < array.length-k+1; i++){
            int minSoFar=0;
            for(int j=i; j< i+k; j++){
                minSoFar= minSoFar+array[j];
            }
            min=Math.min(minSoFar,min);
        }
        return min;
    }

}
