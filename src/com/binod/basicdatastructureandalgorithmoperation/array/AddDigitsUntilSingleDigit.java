package com.binod.basicdatastructureandalgorithmoperation.array;

public class AddDigitsUntilSingleDigit {

    //Using Recursion
    /*public static int addDigits(int num) {
        int num1=0;
        int num2=0;
      if(num <= 9){
          return num;
      }else{
          num1= num %10;
          num2 = num/10;
          return addDigits(num1+num2);
      }
    }*/

    //Without using recursion
    public static int addDigits(int num) {
        if(num <= 9){
            return num;
        }else{
            int result=((num-1)%9) + 1;
            return result;
        }
    }

    public static void main(String[] args) {
        int num=13;
        System.out.println("Aarray list : " + addDigits(num));
        }
}