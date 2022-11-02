package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

//https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
public class UnionAndIntersectionOfTwoSortedArrays {
    //Union and Intersection of two sorted arrays
    //input: arr1[] = {1, 3, 4, 5, 7}, arr2[] = {2, 3, 5, 6}
    //output : Union : {1, 2, 3, 4, 5, 6, 7}, Intersection : {3, 5}

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        //for unique element below code will work
        System.out.println(getUnion(arr1, arr2, arr1.length, arr2.length));
        System.out.println(getIntersection(arr1,arr2,arr1.length,arr2.length));

        int[] arr3 = {1, 3, 3, 5, 7};
        int[] arr4 = {2, 3, 5, 6,6,6};
        //for duplicate element below code will work
        System.out.println(getUnionForUniqueElement(arr3, arr4, arr3.length, arr4.length));
        System.out.println(getIntersectionForUniqueElement(arr3,arr4,arr3.length,arr4.length));
    }

    //Time Complexity: O(m + n) where ‘m’ and ‘n’ are the size of the arrays
    //Auxiliary Space: O(m*log(m)+n*log(n))
    public static List getUnionForUniqueElement(int[] arr1, int[] arr2, int m, int n){
        TreeSet<Integer> set = new TreeSet<>();

        // Remove the duplicates from arr1[]
        for (int i : arr1)
            set.add(i);

        // Remove duplicates from arr2[]
        for (int i : arr2)
            set.add(i);

        // Loading set to array list

        return set.stream().collect(Collectors.toList());
    }

    //Time Complexity: O(m + n) where ‘m’ and ‘n’ are the size of the arrays
    //Auxiliary Space: O(m*log(m)+n*log(n))
    public static List getIntersectionForUniqueElement(int[] arr1, int[] arr2, int m, int n){
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list
                = new ArrayList<>();
        // Remove the duplicates from arr1[]
        for (int i : arr1)
            set.add(i);

        // Remove duplicates from arr2[]
        for (int i : arr2) {
            if(set.contains(i) && !list.contains(i)){
                list.add(i);
            }
        }

        return list;
    }

    //Time Complexity : O(m + n)
    //Auxiliary Space: O(1)
    public static List getUnion(int[] arr, int[] arr1, int m, int n){
        List list= new ArrayList();
        int i=0, j=0;
        while (i<m && j<n){
            if(arr[i]<arr1[j]){
                list.add(arr[i]);
                i++;
            }else if(arr[i] > arr1[j]){
                list.add(arr1[j]);
                j++;
            }else {
                list.add(arr[i]);
                i++;
                j++;
            }
        }

        while(i<m){
            list.add(arr[i]);
            i++;
        }

        while(j<n){
            list.add(arr1[j]);
            j++;
        }

        return list;
    }

    // Time Complexity : O(m + n)
    // Auxiliary Space: O(1)
    public static List getIntersection(int[] arr, int[] arr1, int m, int n){
        List list= new ArrayList();
        int i=0, j=0;
        while (i<m && j<n){
            if(arr[i]<arr1[j]){
                i++;
            }else if(arr[i] > arr1[j]){
                j++;
            }else {
                list.add(arr[i]);
                i++;
                j++;
            }
        }

        while(i<m){
            i++;
        }

        while(j<n){
            j++;
        }

        return list;
    }

}
