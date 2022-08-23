package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.ArrayList;
import java.util.List;

public class UnionAndIntersectionOfTwoSortedArrays {
    //Union and Intersection of two sorted arrays
    //input: arr1[] = {1, 3, 4, 5, 7}, arr2[] = {2, 3, 5, 6}
    //output : Union : {1, 2, 3, 4, 5, 6, 7}, Intersection : {3, 5}

    public static void main(String[] args) {
        int[] arr1={1, 3, 4, 5, 7};
        int[] arr2={2, 3, 5, 6};
        int i=0;
        int j=0;

        List<Integer> list = new ArrayList<>();
        //union of two array
        while (i < arr1.length && j< arr2.length){
                    if (arr1[i] < arr2[j]) {
                        list.add(arr1[i]);
                        i++;
                    } else if (arr1[i] > arr2[j]) {
                        list.add(arr2[j]);
                        j++;
                    } else {
                        list.add(arr1[i]);
                        System.out.println(arr1[i]+" ");
                        i++;
                        j++;
                    }
        }

        while (i< arr1.length){
            list.add(arr1[i]);
            i++;
        }

        while (j< arr2.length){
            list.add(arr2[j]);
            j++;
        }

        System.out.println(list);
    }

}
