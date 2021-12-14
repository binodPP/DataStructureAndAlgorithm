package com.binod.basicdatastructureandalgorithmoperation.array;

public class ReverseTheArray {

    public static void main(String[] args) {
        int[] array={4,5,2,7,8,0,1};

        //Method-1
        int j=array.length-1;
        for(int i=0; i< array.length/2; i ++){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            j--;
        }

        //Method-2
        int start=0;
        int end=array.length-1;
        while(start <= end){
            int temp=array[start];
            array[start]=array[end];
            array[end] = temp;
            start++;
            end--;
        }

        for(int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }
}
