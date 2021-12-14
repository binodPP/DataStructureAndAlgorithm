package com.binod.basicdatastructureandalgorithmoperation.array;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 1, 3, 4, 5,9}, arr2[] = {2, 4, 6, 8};
        mergeTwoSortedArray(arr1,arr2);
    }

    public static void mergeTwoSortedArray(int array1[], int array2[]){

        int[] array3=new int[array1.length+array2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<array1.length && j<array2.length) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];
                i++;
            } else {
                array3[k] = array2[j];
                j++;
            }
            k++;
        }

        while(i < array1.length){
            array3[k]=array1[i];
            i++;
            k++;
        }

        while(j < array2.length){
            array3[k]=array2[j];
            j++;
            k++;
        }

        for(int l=0; l<array3.length;l++){
            System.out.println(array3[l]);
        }
    }
}
