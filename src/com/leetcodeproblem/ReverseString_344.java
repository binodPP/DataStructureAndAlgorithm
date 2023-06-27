package com.leetcodeproblem;
//https://leetcode.com/problems/reverse-string/
public class ReverseString_344 {
    public static void main(String[] args) {
      char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
      int i=0;
      int j=s.length-1;
      while(i<j){
          char temp = s[i];
          s[i] = s[j];
          s[j] = temp;
          i++;
          j--;
      }
        System.out.println(s);
    }

}
