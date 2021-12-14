package com.binod.basicdatastructureandalgorithmoperation.array;

public class SortArrayOf0s1sAnd2s {
    //Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.

    //input : {0, 1, 2, 0, 1, 2}
    //output : {0, 0, 1, 1, 2, 2}

    public static void main(String[] args) {
        int[] array={0, 1, 2, 0, 1, 2};
        sortWithZeroOneAndTwo(array);
    }

    public static void sortWithZeroOneAndTwo(int[] array){
        int low=0;
        int mid=0;
        int high=array.length-1;
        int temp;
        while(mid <=high){
            if(array[mid] ==0){
                temp=array[low];
                array[low]=array[mid];
                array[mid]=temp;
                low++;
                mid++;
            }else if(array[mid] == 1){
                mid++;
            }else if(array[mid] == 2){
                temp=array[mid];
                array[mid]=array[high];
                array[high]=temp;
                high--;
            }
        }

        for(int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
