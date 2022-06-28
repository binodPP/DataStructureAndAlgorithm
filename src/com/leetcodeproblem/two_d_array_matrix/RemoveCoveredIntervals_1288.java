package com.leetcodeproblem.two_d_array_matrix;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals_1288 {
    public static void main(String[] args) {
      int[][] intervals = {{1,2},{1,4},{3,4}};
        System.out.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        //no need to use start index of array because it is already sorted ,
        // we need to use end index to solve this prob after sorting the matrix
       int endIndex=-1;
        int[] prev=intervals[0];
       int length= intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
       for (int i=1; i< intervals.length; i++){
           int[] first=prev;
           int[] second=intervals[i];
           if(second[0]<=first[0] && second[1]>=first[1]){
               length--;
           }else {
               prev=intervals[i];
           }

       }
       return length;
    }
}
