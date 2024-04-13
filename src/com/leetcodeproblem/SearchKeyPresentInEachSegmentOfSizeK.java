package com.leetcodeproblem;

public class SearchKeyPresentInEachSegmentOfSizeK {
    //Given an array arr[] and size of array is n and one another key x,
    // and give you a segment size k. The task is to find that the key x
    // present in every segment of size k in arr[].

    //intput: arr[] = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3}
    //x = 3
    //k = 3
    //output : yes
    //There are 4 non-overlapping segments of size k in the array,
    // {3, 5, 2}, {4, 9, 3}, {1, 7, 3} and {11, 12, 3}. 3 is present all segments.

    public static void main(String[] args) {
        int[] array={3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3};
        int x=3;
        int k=3;
        int i=0;
        boolean isAvailable=false;
        while (i< array.length){
            boolean foundInSegment = false;
            for(int j = i; j< i+k && j< array.length; j++){
                if(array[j] == x){
                    foundInSegment = true;
                    System.out.println(array[j]);
                    break;
                }
            }
            if(!foundInSegment){
                isAvailable = false;
                break;
            }

            isAvailable = true;
            i= i+k;
        }
        System.out.println(isAvailable);
    }


}
