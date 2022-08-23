package com.binod.basicdatastructureandalgorithmoperation.array;

public class DeleteCharactersToMakeFancyString_1957 {
    //https://leetcode.com/problems/delete-characters-to-make-fancy-string/

    public static void main(String[] args) {
        String s = "aaabaaaa";

        System.out.println(makeFancyString(s));
    }

    public static String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prevChar = s.charAt(0);
        result.append(prevChar);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prevChar) {
                count++;
            } else {
                count = 1;
                prevChar = s.charAt(i);
            }
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
