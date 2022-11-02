package com.leetcodeproblem;

//https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr= {2,3,6,7,9};
        int[] arr1= {1,4,8,10};
        int k = 5;
        //1,2,3,4,6,7,8,9,10
        System.out.println(getElementFromSpecified(arr,arr1,arr.length, arr1.length,k));
    }

    public static int getElementFromSpecified(int[] arr, int[] arr1,int m, int n, int k){
        int i=0, j=0, l=0;
        while(i< m && j< n){
            if(arr[i] <= arr1[j]){
                l++;
                if(l == k){
                    return arr[i];
                }
                i++;
            }else{
                l++;
                if(l==k){
                    return arr1[j];
                }
                j++;
            }
        }

        while(i< m){
            l++;
            if(l==k){
                return arr[i];
            }
            i++;
        }

        while(j< n){
            l++;
            if(l==k){
                return arr1[j];
            }
            j++;
        }

        return -1;
    }
}
