package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.Stack;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/

    public static void main(String[] args) {
        String s="()[]{}";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s ==null || s.length()==0 || s.length()==1){
            return false;
        }

        Stack<Character> stack= new Stack<>();
        for (int i=0; i < s.length() ; i++) {
            char c=s.charAt(i);
            if (c == '(' || c== '{' || c== '[') {
                 stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    Character topChar=stack.peek();
                    if(c==')' && topChar == '(' || c=='}' && topChar == '{' || c==']' && topChar == '['){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
