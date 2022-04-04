package com.leetcodeproblem;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    public static void main(String[] args) {
        String str="pwwkew";

        System.out.println(lengthOfLongestSubstring(str));

    }

    //Time Complexity = O(n), space complexity= O(n)
    public static int lengthOfLongestSubstring(String s) {
         Set<Character> characterSet= new HashSet<>();
         int start=0;
         int end=0;
         int result=0;
         if(s.length()==0){
             return 0;
         }

         if(s.length() ==1){
             return 1;
         }

         while (end<s.length()){
             if(!characterSet.contains(s.charAt(end))){
                 characterSet.add(s.charAt(end));
                 result=Math.max(result,characterSet.size());
                 end++;
             }else {
                 characterSet.remove(s.charAt(start));
                 start++;
             }
         }
         return result;
    }
}
