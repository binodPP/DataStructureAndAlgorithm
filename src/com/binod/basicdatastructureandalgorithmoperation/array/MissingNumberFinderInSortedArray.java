package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;

/**
 * Created by 609722983 on 2/23/2020.
 */
public class MissingNumberFinderInSortedArray {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 6};
        int missing = missingNumberFromSortedArray(array);
        System.out.println("Missing number from array : " + Arrays.toString(array) + " is : " + missing);

    }

    private static int missingNumberFromSortedArray(int[] num){
        int left = 0, right = num.length - 1;
        int mid = 0;
        while ((right - left) > 1)
        {
            mid = (left + right) / 2;
            if ((num[left] - left) != (num[mid] - mid))
                right = mid;
            else if ((num[right] - right) != (num[mid] - mid))
                left = mid;
        }
        return (num[mid] + 1);
    }

}
