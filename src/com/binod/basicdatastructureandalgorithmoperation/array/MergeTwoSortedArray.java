package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Map;
import java.util.TreeMap;

public class MergeTwoSortedArray {
    //https://leetcode.com/problems/merge-sorted-array/
    public static void main(String[] args) {
        //int arr1[] = { 1, 3, 4, 5,9}, arr2[] = {2, 4, 6, 8};
        int arr1[] = { 1}, arr2[] = {};
        new MergeTwoSortedArray().merge(arr1,arr1.length,arr2,arr2.length);
        mergeTwoSortedArrayOption2(arr1,arr2);
        mergeTwoSortedArrayUsingTreeMap(arr1,arr2);
    }

    //Best Option-1, with time complexity=O(n+m), space complexity=O(1);
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else {
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }

        while(i>=0){
            nums1[k]=nums1[i];
            k--;
            i--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            k--;
            j--;
        }
        System.out.println("Best Case option After merge:");
        for (int l=0; l<nums1.length;l++) {
            System.out.print(nums1[l] + " ");
        }
        System.out.println("");
    }

    //Option-2- Time Complexity=O(m+n), space complexity=O(m+n)
    public static void mergeTwoSortedArrayOption2(int array1[], int array2[]){

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

    //Option-3- use only if the item in the array is unique , Time Complexity=O(nlog(n) + m log(m)), space complexity=O(n)
    public static void mergeTwoSortedArrayUsingTreeMap(int array1[], int array2[]){

        Map<Integer,Boolean> map= new TreeMap<>();

        for(int i=0; i<array1.length; i++){
            map.put(array1[i],true);
        }

        for(int j=0; j<array2.length; j++){
            map.put(array2[j],true);
        }

        for ( Map.Entry<Integer,Boolean> entry: map.entrySet()) {
            System.out.println("TreeMap sorted array is : " +entry.getKey());
        }

    }
}
