package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;

/**
 * Created by 609722983 on 2/24/2020.
 */

//with constant exta space
// time complexity : O(n)
// extra space : O(1)
public class RemoveDuplicateFromUnsortedArrayWithoutUsingCollection {
    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 1, 2, 2, 3, 4, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 1, 1, 1, 1, 1},};
        int[] array1={1, 1, 2, 2, 3, 4, 5};
        removeDuplicatesFromArrayWithoutUsingCollection(array1);
       /* for(int[] array : test) {
            System.out.println("Array with Duplicates : " + Arrays.toString(array));
            *//*int length = removeDuplicatesFromArrayWithoutUsingCollection(array);
            for (int i = 0; i <= length - 1; i++) {
                System.out.println("After removing duplicates   : " + array[i]);
            }*//*
        }*/


    }

    private static void removeDuplicatesFromArrayWithoutUsingCollection(int[] array){
        //Arrays.sort(array);
        int j=0;
        for(int i=1; i<=array.length-1;i++){
            if(array[i] != array[j]){
                j++;
                array[j]=array[i];
            }
        }
        for(int k=0; k<=j; k++){
            System.out.println("After removing duplicates   : " + array[k]);
        }
    }

    private static void removeDuplicatesFromArray(int[] array){
        Arrays.sort(array);

        int[] result = new int[array.length];
        int previous=array[0];
        result[0]=previous;
        for(int i=1; i<=array.length-1;i++){
            if(previous != array[i]){
                result[i]=array[i];
            }
            previous=array[i];
        }

        for(int i=0; i < result.length; i++){
            if(result[i] !=0)
            System.out.println("Unique : " + result[i]);
        }
    }
}
