package com.leetcodeproblem.two_d_array_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveCoveredIntervals_1288 {
    public static void main(String[] args) {
      int[][] intervals = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        //To solve this problem in Java, you can sort the intervals based on their starting points. Then, iterate through the sorted intervals and keep track of the current maximum ending point. If the current interval's ending point is less than or equal to the maximum ending point, it means it is covered by another interval and can be removed. Otherwise, update the maximum ending point and keep the current interval. Here's the implementation:

        //This solution sorts the intervals in ascending order of starting points. Then, it iterates through the sorted intervals and keeps track of the maximum ending point encountered so far. If the ending point of the current interval is greater than the maximum ending point, it means the current interval is not covered by any other interval, so it is counted in the result. Finally, it returns the count of remaining intervals.
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int remainingIntervals = 0;
        int maxEnd = Integer.MIN_VALUE;

        List<List<Integer>> remainingIntervalsList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                maxEnd = interval[1];
                List<Integer> list = new ArrayList();
                list.add(interval[0]);
                list.add(interval[1]);
                remainingIntervalsList.add(list);
                remainingIntervals++;
            }
        }

        System.out.println(remainingIntervalsList);
        return remainingIntervals;
    }
}
