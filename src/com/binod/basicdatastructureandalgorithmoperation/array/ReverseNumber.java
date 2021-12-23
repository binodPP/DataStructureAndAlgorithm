package com.binod.basicdatastructureandalgorithmoperation.array;

public class ReverseNumber {

    //https://leetcode.com/problems/reverse-integer/
    public static void main(String[] args) {
           int num=123;int reverse=0;
           while(num !=0 ){
               int digit=num%10;
               reverse=reverse*10+digit;
               num=num/10;
           }
        System.out.println(reverse);
    }

    //There's no need for any data type other than int.
    // Just make sure when there's an operation that increases
    // a number, reversing the operation should give you the
    // previous number. Otherwise, there's overflow.

    //option-1 below code is for if integer is out of int range then return 0;
    // other wise use above code for simple reverse int
    //eg: input int x= 1534236469; output should return 0;
    public int reverse(int x) {
        int result=0;
        while(x !=0 ){
            int digit=x%10;
            int reverse=result*10+digit;
            if ((reverse - x%10)/10 != result){
                return 0;
            }else{
                result = reverse;
            }
            x=x/10;
        }
        return result;
    }
}
