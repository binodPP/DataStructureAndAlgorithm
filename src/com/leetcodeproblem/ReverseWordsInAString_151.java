package com.leetcodeproblem;

public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
      StringBuilder stringBuilder = new StringBuilder();
      int i= s.length()-1;
      int j=0;
      while(i>=0){
          if(s.charAt(i) == ' '){
              i--;
          }else {
              j=i;
              while (i>=0 && s.charAt(i) != ' '){
                  i--;
              }
              for (int k =i+1; k<=j;k++){
                  stringBuilder.append(s.charAt(k));
              }

              if(stringBuilder.length() > 1){
                  stringBuilder.append(" ");
              }
          }
      }
      return stringBuilder.toString();
    }
}
