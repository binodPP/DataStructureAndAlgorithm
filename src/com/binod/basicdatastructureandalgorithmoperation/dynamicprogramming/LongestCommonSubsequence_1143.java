package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence_1143 {
    public static void main(String[] args) {
        String s1 ="ABCBDAB";
        String s2 = "BDCABA";

        //System.out.println(longestCommonSubsequence(s1,s2));

        //String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequencePrint(s1,s2));
    }

    //BottomUp Approach: Memoization , TC: O(M*N), SC: O(M*N)
    public static int longestCommonSubsequence(String text1, String text2) {
         int len1 = text1.length();
         int len2 = text2.length();

         if(len1 ==0 || len2 ==0){
             return 0;
         }

         int[][] result = new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            result[i][0] = 0;
        }
        for(int i=0;i<=len2;i++){
            result[0][i] = 0;
        }

         for(int i=1; i<= len1; i++){
             for(int j=1; j<= len2; j++){
                 if(text1.charAt(i-1) == text2.charAt(j-1)){
                     //if the match found then we will copy diogonal value
                     result[i][j]= result[i-1][j-1]+1;
                 }else {
                     //if not match the we will copy max of previous value from pre row and left
                     result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                 }

             }
         }
         return result[len1][len2];

    }


    //Print String BottomUp Approach: Memoization , TC: O(M*N), SC: O(M*N)
    public static String longestCommonSubsequencePrint(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        if(len1 ==0 || len2 ==0){
            return null;
        }

        int[][] result = new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            result[i][0] = 0;
        }
        for(int i=0;i<=len2;i++){
            result[0][i] = 0;
        }

        for(int i=1; i<= len1; i++){
            for(int j=1; j<= len2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    result[i][j]= result[i-1][j-1]+1;
                }else {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }

            }
        }

        int i = len1;
        int j = len2;
        StringBuilder str= new StringBuilder();
        while(i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                str.append(text1.charAt(i-1));
                i--;
                j--;
            }else if(result[i][j-1] > result[i-1][j]){
                j--;
            }else {
                i--;
            }
        }
        return str.toString();
    }
}
