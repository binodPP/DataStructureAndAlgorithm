package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;
// https://www.geeksforgeeks.org/quick-sort/
public class QuickSortAlgorithm_912 {
    public static void main(String[] args) {
        int arr[] = {30, 10, 8, 1, 50, 35};
        int n = arr.length;

        QuickSortAlgorithm_912 ob = new QuickSortAlgorithm_912();
        int low =0;
        int high=n-1;
       // ob.sortAlgorithm(arr, low, high);

        /*for(int i=0; i< arr.length ; i++){
            System.out.println("Arrays : " + arr[i]);
        }*/

        quickSort(arr,low,high);

        for(int i=0; i< arr.length ; i++){
            System.out.println("Arrays : " + arr[i]);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Choose any pivot index here, for example, the middle index
            //int pivotIndex = low;
            //int pivotIndex = low + (high - low) / 2;
            int pivotIndex = high;
            int partitionIndex = partition(arr, low, high, pivotIndex);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    //This function will work for any pivot position
    public static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move pivot element to the end
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high); // Move pivot element back to its final place
        return i; // Return the partition index
    }

    //Time complexity= O(n * log(n)), recursion call stack space complexity= O(n)
    //imagine pivot element is last one
    public static int partition_Pivot_Last(int[] arr, int low, int high) {
        int pivot = arr[high]; // Selecting the last element as the pivot
        int i = low - 1; // index of the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot (arr[high]) with arr[i+1]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the partition index
    }


    //Time complexity= O(n * log(n)), recursion call stack space complexity= O(n)
    //imagine pivot element is first one
    public static int partition_Pivot_First(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1; // index of the first element greater than pivot
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // Swap pivot (arr[low]) with arr[i-1]
        int temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1; // Return the partition index
    }

    public static int partition_Pivot_Middle(int[] arr, int low, int high) {
        int pivotIndex = low + (high - low) / 2; // Selecting the middle element as the pivot
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move pivot element to the end
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high); // Move pivot element back to its final place
        return i; // Return the partition index
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortAlgorithm(int array[], int low, int high){

            if(high > low) {

                int pivotIndex = partition_Pivot_First(array, low, high);

                sortAlgorithm(array, low, pivotIndex - 1);
                sortAlgorithm(array, pivotIndex + 1, high);
            }

    }

}
