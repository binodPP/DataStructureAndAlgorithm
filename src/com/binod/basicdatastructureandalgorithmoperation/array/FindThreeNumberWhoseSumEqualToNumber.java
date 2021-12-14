package com.binod.basicdatastructureandalgorithmoperation.array;

public class FindThreeNumberWhoseSumEqualToNumber {
    public static void main(String[] args) {
        int[] array ={1,3,2,5,1,6};

        for(int i=0 ; i< array.length ; i++){
            for(int j=i+1; j<array.length; j++){
                for(int k = j+1; k<array.length; k++){
                    if(array[i]+array[j]+array[k]==7) {
                        System.out.println(array[i]+","+array[j]+","+array[k]);
                    }
                }
            }
        }
    }
}
