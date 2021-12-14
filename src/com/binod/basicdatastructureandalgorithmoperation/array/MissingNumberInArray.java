package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by 609722983 on 2/11/2020.
 */
public class MissingNumberInArray {
    public static int count = 0;
    public static int position = 0;
    public static boolean flag = false;

    public static void main(String[] args) {
        //Method 1
        int a[] = {1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23};
        int b[] = new int[100];

        int max =calculateMaxArrayValue(a);

        for(int i=0; i < a.length; i++){
            b[a[i]]=1;
        }
        System.out.println("Missing numbers in array are: ");
        for(int i=1 ; i <=max; i++){
            if(b[i]==0){
                System.out.println(i+"");
            }
        }


        //Method 2

        int[] numbers = {10, 11, 12, 13, 14, 15, 18, 20, 21, 23};;
        Arrays.sort(numbers);
        HashSet<Integer> set = new HashSet<>();

        for (int i = numbers[0]; i < numbers[numbers.length - 1]; i++) {
            set.add(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            set.remove(numbers[i]);
        }

        for (int x : set) {
            System.out.println("Missing Arrays are : " + x);
        }

        //Method 3
        System.out.println("Missing Number is : "+getMissingNo(a,numbers.length));
    }

    //Method 3

    static int getMissingNo(int a[], int n)
    {
        int n_elements_sum = n * (n + 1) / 2;
        int sum = 0;

        for(int i = 0; i < n - 1; i++)
            sum += a[i];

        return n_elements_sum - sum;
    }

    private static int calculateMaxArrayValue(int input[]) {
           int max=input[0];
           for(int i=1;i<input.length;i++){
               if(input[i] > max){
                   max= input[i];
               }
           }
           return max;
    }


}
