package com.binod.basicdatastructureandalgorithmoperation.sortingalgorithm;

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
    public static int arrayPartition(int arr[],int low, int high){
          int pivot = arr[high];
          int i = low;
          for(int j = low; j < high ; j++){
              if(arr[j] <= pivot){
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
                  i++;
              }
          }
          int temp =arr[i];
          arr[i] = arr[high];
          arr[high] = temp;
          return i;
    }

    public static void sortAlgorithm(int array[], int low, int high){

            if(high <= low)
                return;

            int pivotIndex= arrayPartition(array,low,high);

            sortAlgorithm(array,low, pivotIndex-1);
            sortAlgorithm(array,pivotIndex+1,high);

    }

}
