package com.binod.basicdatastructureandalgorithmoperation.array;

public class CyclicallyRotateArraybyOne {
   //input: arr[] = {1, 2, 3, 4, 5}
   //Output: arr[] = {5, 1, 2, 3, 4}
    public static void main(String[] args) {
        int[] array={1, 2, 3, 4, 5};
        cyclicRotateArray(array);
    }

    public static void cyclicRotateArray(int[] array){
        int temp;
        for(int i=array.length-1;i>0; i--){
            temp=array[i];
            array[i]=array[i-1];
            array[i-1]=temp;
        }

        for(int j=0; j < array.length; j++){
            System.out.println(array[j]);
        }
    }
}
