package com.binod.basicdatastructureandalgorithmoperation.array;

public class ImplementstrStrFunction_28 {
    //https://leetcode.com/problems/implement-strstr/

    public static void main(String[] args) {
        String haystack = "miissippiss" , needle = "issippi";

        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {

        if((needle ==null || needle.isEmpty())){
            return 0;
        }
        for(int i=0; i< haystack.length()-needle.length()+1; i++){
            if(haystack.startsWith(needle, i)){
                return i;
            }
        }

        /*for(int i=0; i< haystack.length()-needle.length()+1; i++){
            if(needle.equalsIgnoreCase(haystack.substring(i,i+needle.length()))){
                return i;
            }
        }*/
        return -1;
    }
}
