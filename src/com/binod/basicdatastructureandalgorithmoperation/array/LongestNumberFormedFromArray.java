package com.binod.basicdatastructureandalgorithmoperation.array;

public class LongestNumberFormedFromArray {
     public static String formLongestNumberFromArray(int[] number){
         String sum="",sum1="", longest="";
         for(int i=1; i < number.length ; i++) {
             if (number.length == 1) {
                 return String.valueOf(number[0]);
             }else{
                 String str1=String.valueOf(number[i]);
                 if(i==1) {
                     String str = String.valueOf(number[i - 1]);
                     sum=longest+str+str1;
                     sum1=str1+str+longest;
                 }else{
                     sum=longest+str1;
                     sum1=str1+longest;
                 }
                 //sum1=str1+longest;
                 if(sum.compareTo(sum1) >0){
                     longest=sum;
                 }else{
                     longest=sum1;
                 }
             }
         }
         return longest;
     }

    public static void main(String[] args) {
        //int[] num= {3,30,34,9};
        int[] num= {2,33,55,3};
        System.out.println("Longest number from an array : " + formLongestNumberFromArray(num));

    }
}