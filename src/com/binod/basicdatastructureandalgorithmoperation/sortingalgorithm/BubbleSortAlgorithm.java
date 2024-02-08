package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;

import java.util.Arrays;

public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        System.out.println("Original Array: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
