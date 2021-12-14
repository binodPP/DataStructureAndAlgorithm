package com.binod.basicdatastructureandalgorithmoperation.array;

public class ArrayJumbleTask {

    public static void main(String[] args) {

        int[] array ={1,4,6,3,8,9};
        /*int[] array1= new int[array.length];
        int count=0;
        for(int i =2; i < array.length; i ++){
            array1[i-2]= array[i];
            count++;
        }

        int j =0;
        while(count < array.length){
            array1[count] = array[j];
            count++;
            j++;
        }

        for(int i = 0; i < array1.length ; i++) {
            System.out.println(array1[i]);
        }*/

        for(int i=2; i< array.length; i ++){
            int temp=array[i-2];
            array[i-2]=array[i];
            array[i]=temp;

        }

        for(int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
