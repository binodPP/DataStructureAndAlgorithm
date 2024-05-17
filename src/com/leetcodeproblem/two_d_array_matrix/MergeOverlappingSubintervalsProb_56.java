package com.leetcodeproblem.two_d_array_matrix;

import java.util.*;
import java.util.stream.Collectors;

public class MergeOverlappingSubintervalsProb_56 {
    //https://leetcode.com/problems/merge-intervals/
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)};
        mergeOption(intervals);
    }

    // Time Complexity: O(NlogN)+O(N). O(NlogN) for sorting the array,
    // and O(N) because we are checking to the right for each index which is a for loop.so final complexity is O(n).

    //Space Complexity: O(1), as we are using stack a separate data structure.

    public static void mergeOption(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[index].end >= intervals[i].start) {
                // Merge the intervals
                intervals[index].end = Math.max(intervals[index].end, intervals[i].end);
            } else {
                // No overlap, move to the next interval
                index++;
                intervals[index] = intervals[i];
            }
        }

        System.out.print("The Merged Intervals are: " + intervals.length);
        for (int j = 0; j <= index; j++) {
            System.out.print("[" + intervals[j].start + "," + intervals[j].end + "] ");
        }
    }

    public static class Interval{
        int start,end;
        public Interval(int x, int y){
            this.start=x;
            this.end=y;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

}

