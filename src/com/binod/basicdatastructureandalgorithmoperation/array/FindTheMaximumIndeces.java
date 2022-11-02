package com.binod.basicdatastructureandalgorithmoperation.array;
//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class FindTheMaximumIndeces {
    //Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
    // Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
    //  Output: 6  (j = 7, i = 1)

    public static void main(String[] args) {
        int[] array={34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(findMaxIndices(array));
    }

    public static int findMaxIndices(int[] array){
        int max=0;
        for(int i =0; i < array.length; i++){
            for(int j=i+1; j<array.length ; j++){
                if(array[j] > array[i] && max < j-i){
                    max=j-i;
                }
            }
        }
        return max;
    }


}
