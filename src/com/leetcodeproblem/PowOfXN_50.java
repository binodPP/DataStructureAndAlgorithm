package com.leetcodeproblem;

//https://leetcode.com/problems/powx-n/description/
//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class PowOfXN_50 {
    public static void main(String[] args) {
        int n=10;
        double x=2.0;

        System.out.println(myPow(x,n));
    }

    //Time Complexity log(n) space =o(1)
    public static double myPow(double x, int n) {
        long num = n;
        double result=1.0;
        if(n<0){
            num = -1*num;
        }

        while(num > 0){
            if(num%2==0){
                x= x * x;
                num = num/2;
            }else {
                result = result * x;
                num = num -1;
            }
        }

        if(n < 0){
            return 1.0 / result;
        }
        return result;
    }
}
