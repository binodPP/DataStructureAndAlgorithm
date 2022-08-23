package com.leetcodeproblem;

//https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes_172 {
    public static void main(String[] args) {
      int n = 20;
        System.out.println(trailingZeroes(n));
    }

    //Time Complexity = O(log n), space = O(1)
    // 1*10 = 10(one trailing zero), 1*10*10= 100(two trailing zero) means 2*5=10 we need
    // to consider always but because 5 will always come less so we will only take 5 instead of combination (2,5)
    public static int trailingZeroes(int n) {
        int count=0;
        while(n>0){
            count=count+n/5;
            n=n/5;
        }
        return count;
    }
}
