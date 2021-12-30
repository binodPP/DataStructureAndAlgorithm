package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.*;

public class MergeOverlappingSubintervalsProb {
    //https://leetcode.com/problems/merge-intervals/
    public static void main(String[] args) {
        Intervals arr[]=new Intervals[2];
        /*arr[0]=new Intervals(6,8);
        arr[1]=new Intervals(1,9);
        arr[2]=new Intervals(2,4);
        arr[3]=new Intervals(4,7);*/
        arr[0]=new Intervals(1, 4);
        arr[1]=new Intervals(5, 6);
        //arr[2]=new Intervals(8, 10);
        //arr[3]=new Intervals(15, 18);

        //int[][] arr1={{1,3},{2,6},{8,10},{15,18}};
        int[][] arr1={{1,4},{5,6}};

        new MergeOverlappingSubintervalsProb().merge(arr);
        new MergeOverlappingSubintervalsProb().mergeOption3(arr1);
    }

    //Option-1:
    // Time Complexity: O(NlogN)+O(N). O(NlogN) for sorting the array,
    // and O(N) because we are checking to the right for each index which is a for loop.so final complexity is O(n).

    //Space Complexity: O(N), as we are using stack a separate data structure.

    public void merge(Intervals[] intervals) {
        Stack<Intervals> stack= new Stack();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        stack.push(intervals[0]);

        for(int i=1; i<intervals.length;i++){
            Intervals top= stack.peek();
            if(top.end<intervals[i].start){
                stack.push(intervals[i]);
            }else {
                top.end=intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.print("The Merged Intervals are: ");
        while(!stack.isEmpty()){
            Intervals t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }


    //Option-2:
    // Time Complexity: O(NlogN)+O(N). O(NlogN) for sorting the array,
    // and O(N) because we are checking to the right for each index which is a for loop.so final complexity is O(n).

    //Space Complexity: O(1), as we are using stack a separate data structure.

    public void mergeOption2(Intervals[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        int index=0;

        for(int i=1; i<intervals.length;i++){

            if(intervals[index].end > intervals[i].start){
                intervals[index].end=Math.max(intervals[index].end,intervals[i].end);
                intervals[index].start=Math.min(intervals[index].start,intervals[i].start);
            }else {
                index++;
                intervals[index]=intervals[i];
            }
        }

        System.out.print("The Merged Intervals are: ");
        int j=0;
        while(j<=index){
            System.out.print("["+intervals[j].start+","+intervals[j].end+"] ");
            j++;
        }
    }

    public int[][] mergeOption3(int[][] intervals) {

        List<int[]> arrayList= new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index=0;
        if(intervals.length==1){
            arrayList.add(intervals[intervals.length-1]);
        }
        for(int i=1; i<intervals.length;i++){
            if(intervals[index][1] >= intervals[i][0]){
                intervals[index][1]=Math.max(intervals[index][1],intervals[i][1]);
                //intervals[index][0]=Math.min(intervals[index][0],intervals[i][0]);
                arrayList.add(intervals[index]);
            }else {
                if(intervals.length>2) {
                    index++;
                    //intervals[index]=intervals[i];
                    arrayList.add(intervals[index]);
                }else {
                    index++;
                    arrayList.add(intervals[index-1]);
                    arrayList.add(intervals[index]);

                }

            }
        }
        arrayList.stream().distinct();
        return arrayList.toArray(new int[arrayList.size()-1][arrayList.size()-1]);
    }


}

class Intervals{
    int start,end;
    public Intervals(int x, int y){
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
