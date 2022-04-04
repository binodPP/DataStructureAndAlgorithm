package com.leetcodeproblem;

public class LongestCommonPrefix_14 {
    //https://leetcode.com/problems/longest-common-prefix/solution/

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result=strs[0];
        if(strs.length==0){
             return "";
         }
         if(strs.length ==1){
             return strs[0];
         }

         for(int i=1; i< strs.length; i++){
             result=longestCommonPrefixHelper(result,strs[i]);
         }
         return result;
    }

    public static String longestCommonPrefixHelper(String str1, String str2){
        String str3="";
        for(int i=0, j=0; i< str1.length() && j< str2.length(); i++,j++){
            if(str1.charAt(i)!=str2.charAt(j)){
                break;
            }
            str3=str3+str1.charAt(i);
        }
        return str3;
    }


}
