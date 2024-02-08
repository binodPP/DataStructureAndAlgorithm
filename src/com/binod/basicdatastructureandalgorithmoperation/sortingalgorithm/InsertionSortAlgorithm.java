package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;

import java.util.Arrays;

public class InsertionSortAlgorithm {
        public static void main(String[] args) {
            int[] array = {5, 3, 8, 4, 2};
            System.out.println("Original Array: " + Arrays.toString(array));

            insertionSort(array);

            System.out.println("Sorted Array: " + Arrays.toString(array));
        }

        public static void insertionSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
}
