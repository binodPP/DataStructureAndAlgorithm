package com.leetcodeproblem;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring_05 {
    int start =0; int end=0;
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring_05().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        for(int i=0; i< s.length(); i++){
            expandSubstring(s,i,i);
            expandSubstring(s,i,i+1);
        }
        return s.substring(start,end+1);
    }

    public  void expandSubstring(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        left = left+1;
        right = right-1;

        if(end - start +1 < right - left +1){
            start = left;
            end = right;
        }

    }
}
