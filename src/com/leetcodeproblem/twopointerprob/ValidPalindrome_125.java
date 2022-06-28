package com.leetcodeproblem.twopointerprob;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    //TimeComplexity= O(n), space complexity= O(1)
    public static boolean isPalindrome(String s) {
      int i=0;
      int j=s.length()-1;
      while(i<=j){
          if(!Character.isLetterOrDigit(s.charAt(i))){
              i++;
          }else if(!Character.isLetterOrDigit(s.charAt(j))){
              j--;
          }else {
              if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                  return false;
              }
              i++;
              j--;
          }
      }
      return true;
    }
}
