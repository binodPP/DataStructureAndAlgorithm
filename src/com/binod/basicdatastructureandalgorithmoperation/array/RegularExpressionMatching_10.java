package com.binod.basicdatastructureandalgorithmoperation.array;

public class RegularExpressionMatching_10 {
   //https://leetcode.com/problems/regular-expression-matching/
    public static void main(String[] args) {
        String s = "aa";
        String pattern = "a";
        System.out.println(isMatch(s,pattern));
    }


    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
