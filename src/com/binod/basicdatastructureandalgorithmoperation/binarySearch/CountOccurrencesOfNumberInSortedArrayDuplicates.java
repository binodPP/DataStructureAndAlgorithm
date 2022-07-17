package com.binod.basicdatastructureandalgorithmoperation.binarySearch;

public class CountOccurrencesOfNumberInSortedArrayDuplicates {
    //https://www.techiedelight.com/count-occurrences-number-sorted-array-duplicates/
    public static void main(String[] args) {
        int nums[] = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target=9;

        int firstOccurrence= binarySearch(nums,target,true);
        int lastOccurrence= binarySearch(nums,target,false);

        int count = lastOccurrence - firstOccurrence +1;

        System.out.println(count);

    }

    public static int binarySearch(int[] nums, int target, boolean searchFirst){
       int left=0;
       int right=nums.length-1;
       int res=-1;

       while(left<=right){

           int mid = (left + right)/2;

           if(target == nums[mid]){
               res = mid;

               if(searchFirst){
                   right = mid -1;
               }else {
                   left = mid +1;
               }
           }else if(target < nums[mid]){
               right = mid -1;
           }else {
               left = mid +1;
           }
       }

       return res;
    }

}
