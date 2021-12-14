package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;

public class ReverseArrayWthoutUsingAnotherArray {
    //Write a java program to reverse an array without using an additional array?
    public static void main(String[] args) {

        reverseArray(new int[]{12, 9, 21, 17, 33, 7});
    }

    public static void reverseArray(int[] array){
        int temp;
        for(int i=0; i < array.length/2 ; i++){
            temp= array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
