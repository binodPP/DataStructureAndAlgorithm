package com.leetcodeproblem;

public class FactorialTrailingZeroes_172 {
    public static void main(String[] args) {
      int n = 100;
        System.out.println(trailingZeroes(n));
    }

    //Time Complexity = O(log n), space = O(1)
    public static int trailingZeroes(int n) {
        int count=0;
        while(n>0){
            count=count+n/5;
            n=n/5;
        }
        return count;
    }
}
