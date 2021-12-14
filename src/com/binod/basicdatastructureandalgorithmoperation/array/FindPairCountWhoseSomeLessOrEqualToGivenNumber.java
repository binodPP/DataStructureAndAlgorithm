package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairCountWhoseSomeLessOrEqualToGivenNumber {
    public static void main(String[] args) {
        double[] array={1.01, 1.99, 2.5, 1.5, 1.01};
        //output: 1.01 + 1.99, 2.5, 1.5+1.01
        //Arrays.sort(array);
        System.out.println("Total Count of pairs Whose Some LessOrEqual To GivenNumber : " + findThePairs1(array));
        System.out.println("Total Count of pairs Whose Some LessOrEqual To GivenNumber Method 2 : " + findThePairs2(array));
        int[] array1={1, 5, 7, -1};
        int k=6;
        //countThePairs(array1,k);
    }

    //Method 1 using two for loop
    // time complexity= O(n*n)
    public static int findThePairs1(double[] array){
        int count=0;
        for(int i=0; i < array.length; i++){
            for(int j=i+1; j< array.length; j++){
                if(array[i] + array[j] <=5){
                    count++;
                    System.out.println(array[i] +"+"+array[j]+"<="+3.00);
                }
            }
        }
        return count;
    }

    public static int countThePairs(int[] array, int k){
        int count=0;

        Map map= new HashMap<>();
        for(int i=0; i < array.length; i++){
            if(map.containsKey(array[i])){
                count++;
                System.out.println(array[i]+"+"+map.get(array[i])+"="+k);
            }else {
                map.put(k-array[i],array[i]);
            }
        }
        System.out.println(count);
        return count;
    }

    //Method 2 using two pointer
    // time complexity= O(n)
    public static int findThePairs2(double[] array){
        int count=0;
        int left=0;
        int right=array.length-1;
        while(left <=right){
            if(left == right){
                count++;
                break;
            }
            if(array[left]+array[right] <= 3.0){
                count++;
                System.out.println(array[left] +"+"+array[right]+"<="+3.0);
                left++;
                right--;
            }else {
                right--;
                count++;
            }
        }
        return count;
    }
}
