package com.binod.basicdatastructureandalgorithmoperation.array;

public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        /*int count=0;
        int i=1;
        if(n <=9 && n >0){
            return 1;
        }
        while(i<=n && n >0){
            String s=String.valueOf(i);
            if(s.contains("1")){
                count++;
            }
            i++;
        }
        return n>0?count:0;*/
        int count = 0;
        int i = 1;
        while (i <= n) {
            String s = String.valueOf(i);
            count += s.split("1", -1).length-1;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num=22;
        System.out.println("Tolal ocurance of 1 in a given number is : " + countDigitOne(num));

    }
}