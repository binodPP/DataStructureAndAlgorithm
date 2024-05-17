package com.leetcodeproblem.twopointerprob;

public class IsSubString {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbabcdc";
        System.out.println(isSubsequence(s,t));
    }

    // //TimeComplexity= O(max (m,n), space complexity= O(1)
    public static boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                i=0;
                j++;
            }
        }

        if(i == s.length()){
            return true;
        }
        return false;
    }
}
