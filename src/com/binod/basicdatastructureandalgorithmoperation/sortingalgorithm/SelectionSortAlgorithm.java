package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;

import java.util.Arrays;

public class SelectionSortAlgorithm {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        System.out.println("Original Array: " + Arrays.toString(array));

        selectionSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
