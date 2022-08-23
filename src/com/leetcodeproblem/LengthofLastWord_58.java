package com.leetcodeproblem;
//https://leetcode.com/problems/length-of-last-word/
public class LengthofLastWord_58 {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        String s1="Hello World";

        System.out.println(lengthOfLastWord(s1));
    }

    public static int lengthOfLastWord(String s) {
        int i= s.length()-1;
        int j;
        while(i>=0){
            if(s.charAt(i) == ' '){
                i--;
            }else {
                j=i;
                while (i>=0 && s.charAt(i) != ' '){
                    i--;
                }
                return j-i;
            }
        }

        return 0;
    }
}
