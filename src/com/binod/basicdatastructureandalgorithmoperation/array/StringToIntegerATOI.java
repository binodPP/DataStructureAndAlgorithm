package com.binod.basicdatastructureandalgorithmoperation.array;


public class StringToIntegerATOI {

    //https://leetcode.com/problems/string-to-integer-atoi/
    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));
    }

    //
    public static int myAtoi(String s) {
        double result=0;
        char sign='+';

        // trim white spaces
        s=s.trim();

        if(s.length() ==0 || s.length() <1){
            return 0;
        }

        int i=0;
        if(s.charAt(0) == '-'){
            sign='-';
            i++;
        }else if(s.charAt(0) == '+'){
            i++;
        }

        while(s.length() > i && s.charAt(i) >= '0' && s.charAt(i)<='9'){
            result=result*10+s.charAt(i)-'0';
            i++;
        }

        if(sign == '-'){
            result=-result;
        }

        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
