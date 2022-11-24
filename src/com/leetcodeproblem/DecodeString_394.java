package com.leetcodeproblem;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString_394 {
    public static void main(String[] args) {
      String s="3[a]2[bc]";
        System.out.println(decodeString(s));
    }
    //TC: O(N), SC: O(2N)=O(N)
    public static String decodeString(String s) {
        Stack strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        int len= s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i< len; i ++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + (s.charAt(i+1)-'0');
                    i++;
                }
                numStack.push(num);
            }else if(c == '['){
                strStack.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }else if(c == ']'){
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop().toString());
                for(int j=0; j< count; j++){
                    temp.append(stringBuilder);
                }
                stringBuilder= temp;

            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
