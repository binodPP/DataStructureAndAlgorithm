package com.leetcodeproblem;

import java.util.Stack;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString_1047 {
    public static void main(String[] args) {
     String str = "abbaca";

        System.out.println(removeDuplicates(str));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                    stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        for (Character c: stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
