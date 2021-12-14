package com.binod.basicdatastructureandalgorithmoperation.array;

/**
 * Created by 609722983 on 2/24/2020.
 */
public class GCDORGCFORHCF {

    public static void main(String[] args) {
        int firstNumber=54;
        int secondNumber=24;
        System.out.println("GCD of two numbers : " + firstNumber +" and " +
                secondNumber + " is : " + findGCDOrGCFOrHCFOfTwoNumber(firstNumber,secondNumber));

    }

    private static int findGCDOrGCFOrHCFOfTwoNumber(int num1, int num2 ){
        //A more efficient solution is to use modulo operator in Euclidean algorithm .
        if(num2==0){
            return num1;
        }else{
            return findGCDOrGCFOrHCFOfTwoNumber(num2,num1%num2);
        }

    }
}
