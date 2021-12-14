package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;

/**
 * Created by 609722983 on 2/26/2020.
 */

/*
Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.

        If it is impossible to form any triangle of non-zero area, return 0.

Note:   3 <= A.length <= 10000
        1 <= A[i] <= 10^6
*/


public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] arrayList={2,1,2};
        //int[] arrayList={1,2,1};
        //int[] arrayList={3,6,2,3};
        //int[] arrayList={6, 1, 6, 5, 8, 4};
        largestPerimeter(arrayList);

    }

    private static int largestPerimeter(int[] A) {
        int max=0;
        Arrays.sort(A);
        for(int i=A.length-3; i >= 0; i--){
            if(A[i]+A[i+1] > A[i+2]){
              max=Math.max(max,A[i]+A[i+1]+ A[i+2]);
            }
        }
        if(max>0){
            return max;
        }

        return 0;
    }
}
