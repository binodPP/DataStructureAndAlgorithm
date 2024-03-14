package com.leetcodeproblem;

public class MoveAllNegativeNumbersBeginningAndPositiveEnd {
    //Move all negative numbers to beginning and positive to end with constant extra space
    //input : {-12, 11, -13, -5, 6, -7, 5, -3, -6}
    //output: {-12, -13, -5, -7, -3, -6, 11, 6, 5}

    public static void main(String[] args) {
        int[] array={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int temp;
        int j=0;
        int i=0;
        /*for(int i=0; i < array.length; i++){
            if(array[i] <0){
                if(i !=j) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                j++;
            }

        }*/

        while(i< array.length){
            if(array[i] <0){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                i++;
                j++;
            }else {
                i++;
            }

        }

        for(int k=0; k < array.length;k++){
            System.out.println(array[k]);
        }
    }
}
