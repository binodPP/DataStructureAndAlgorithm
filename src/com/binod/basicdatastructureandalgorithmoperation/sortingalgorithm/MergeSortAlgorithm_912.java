package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;

//https://www.geeksforgeeks.org/merge-sort/
public class MergeSortAlgorithm_912 {

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        int low =0;
        int high= arr.length-1;

        MergeSortAlgorithm_912 ob = new MergeSortAlgorithm_912();
        ob.sort(arr, low, high);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //Time complexity= O(n * log(n)), recursion call stack space complexity= O(n)
    public static void mergeSort(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L= new int[n1];
        int[] R= new int[n2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into arr[l..r]

        // Initial index of first subarray
        int i = 0;

        // Initial index of second subarray
        int j = 0;

        // Initial index of merged subarray
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of
        // L[], if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of
        // R[], if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public void sort(int[] array, int low, int high) {

        if( low < high) {
            int mid = (low+high)/2;

            sort(array, low, mid);
            sort(array, mid + 1, high);
            mergeSort(array, low, mid, high);
        }

    }
}
