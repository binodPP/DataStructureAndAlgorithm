package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairCountWhoseSomeLessOrEqualToGivenNumber {
    public static void main(String[] args) {
        //double[] array={1.01, 1.99, 2.5, 1.5, 1.01};
        //output: 1.01 + 1.99, 2.5, 1.5+1.01
        //Arrays.sort(array);
        int[] array={1, 3, 4, 2, 10, 11};
        System.out.println("Total Count of pairs Whose Some LessOrEqual To GivenNumber : " + findThePairs1(array));
        System.out.println("Total Count of pairs Whose Some LessOrEqual To GivenNumber Method 2 : " + findThePairs2(array));

        int k=7;
        //countThePairs(array1,k);
    }

    //Method 1 using two for loop
    // time complexity= O(n*n)
    public static int findThePairs1(int[] array){
        int count=0;
        for(int i=0; i < array.length; i++){
            for(int j=i+1; j< array.length; j++){
                if(array[i] + array[j] <=7){
                    count++;
                    System.out.println(array[i] +"+"+array[j]+"<="+6);
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
    // time complexity= O(n log(n))
    public static int findThePairs2(int[] array){
        int count=0;
        int left=0;
        int right=array.length-1;
        Arrays.sort(array);

        while(left <= right){
            if(array[left]+array[right] <= 7){
                count= count + right-left+1;
                left++;
                right--;
            }else if(array[left]+array[right] > 7) {
                right--;
            }
        }
        return count;
    }
}
