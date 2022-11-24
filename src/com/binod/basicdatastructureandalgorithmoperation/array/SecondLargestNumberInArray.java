package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by 609722983 on 2/12/2020.
 */
public class SecondLargestNumberInArray {
    public static void main(String[] args) {
        int[] numbers = {11, 46,10,3,5,7};;

        int largest=0;
        int secondLargest=0;
        int thirdLargest=0;
        for(int i=0 ; i< numbers.length;i++){
            if(numbers[i] > largest){
                secondLargest=largest;
                largest=numbers[i];
            }else if( numbers[i] > secondLargest){
                thirdLargest=secondLargest;
                secondLargest=numbers[i];
            }else if(numbers[i] > thirdLargest){
                thirdLargest=numbers[i];
            }

            }
        System.out.println("Largest number : "+ largest);
        System.out.println("Second largest number : "+ secondLargest);
        System.out.println("third largest number : "+ thirdLargest);

        System.out.println("======================================================");

        //2nd method
        Arrays.sort(numbers);

        System.out.println("Largest number : "+ numbers[numbers.length-1]);
        System.out.println("Second largest number : "+ numbers[numbers.length-2]);
        System.out.println("third largest number : "+ numbers[numbers.length-3]);
        }
    }

