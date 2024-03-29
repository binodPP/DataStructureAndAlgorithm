package com.leetcodeproblem;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        int x=121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        int reverse=0;
        int originalNumber = x;
        if(x < 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        while(x > 0 ){
            int digit=x%10;
            reverse=reverse*10+digit;
            x=x/10;
        }

        return originalNumber == reverse;
    }
}
