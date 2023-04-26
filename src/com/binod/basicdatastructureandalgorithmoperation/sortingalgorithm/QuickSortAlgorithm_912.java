package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;
// https://www.geeksforgeeks.org/quick-sort/
public class QuickSortAlgorithm_912 {
    public static void main(String[] args) {
        int arr[] = {30, 10, 8, 1, 50, 35};
        int n = arr.length;

        QuickSortAlgorithm_912 ob = new QuickSortAlgorithm_912();
        int low =0;
        int high=n-1;
        ob.sortAlgorithm(arr, low, high);

        for(int i=0; i< arr.length ; i++){
            System.out.println("Arrays : " + arr[i]);
        }
    }

    //Time complexity= O(n * log(n)), recursion call stack space complexity= O(n)
    //imagine pivot element is last one
    public static int arrayPartition(int array[],int low, int high){
        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    //Time complexity= O(n * log(n)), recursion call stack space complexity= O(n)
    //imagine pivot element is last one
    public static int arrayPartition1(int array[],int low, int high){
        // choose the rightmost element as pivot
        int pivot = array[low];

        // pointer for greater element
        int i = high;

        // traverse through all elements
        // compare each element with pivot
        for (int j = high; j > low; j--) {
            if (array[j] > pivot) {

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i--;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = array[i];
        array[i] = array[low];
        array[low] = temp;

        // return the position from where partition is done
        return (i);
    }

    public static void sortAlgorithm(int array[], int low, int high){

            if(high > low) {

                int pivotIndex = arrayPartition1(array, low, high);

                sortAlgorithm(array, low, pivotIndex - 1);
                sortAlgorithm(array, pivotIndex + 1, high);
            }

    }

}
