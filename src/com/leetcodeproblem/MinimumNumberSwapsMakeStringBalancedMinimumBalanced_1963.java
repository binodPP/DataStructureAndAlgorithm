package com.leetcodeproblem;

import java.util.Stack;

//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
public class MinimumNumberSwapsMakeStringBalancedMinimumBalanced_1963 {
    public static void main(String[] args) {
    String s="))()(()(";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps (String s) {
        Stack <Character> stack = new Stack ();
        int mismatch = 0;
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch == '(')
                stack.push (ch);
            else {
                if (!stack.isEmpty ())
                    stack.pop ();
                else
                    mismatch++;
            }
        }
        //(mismatch + 1) to take the odd number count
        return (mismatch + 1) / 2;
    }
}
