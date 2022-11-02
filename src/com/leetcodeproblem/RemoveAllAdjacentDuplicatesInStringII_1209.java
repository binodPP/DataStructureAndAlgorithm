package com.leetcodeproblem;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesInStringII_1209 {
    public static void main(String[] args) {
        //String str="deeedbbcccbdaa";
        String str="pbbcggttciiippooaais";
        //String str="abcd";

        int k=2;

        System.out.println(removeDuplicates(str,k));

    }

    public static String removeDuplicates(String s, int k) {
        Stack<StackHelper> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< s.length(); i++){
            if(!stack.isEmpty()) {
                StackHelper stackHelper = stack.peek();
                if (s.charAt(i) == stackHelper.getCharacter()) {
                    stack.pop();
                    int count = stackHelper.getCount()+1;
                    if( count != k) {
                        stack.add(new StackHelper(s.charAt(i), count));
                    }

                } else {
                    stack.add(new StackHelper(s.charAt(i), 1));
                }

            }else {
                stack.add(new StackHelper(s.charAt(i), 1));
            }
        }

        while (!stack.isEmpty()){
            StackHelper stackHelper= stack.pop();
            int i=0;
                while (i<stackHelper.getCount()) {
                    stringBuilder.append(stackHelper.getCharacter());
                    i++;
                }
        }

        return stringBuilder.reverse().toString();
    }

    public static class StackHelper{
        char character;
        int count;

        public StackHelper(char character, int count){
            this.character= character;
            this.count = count;

        }

        public char getCharacter() {
            return character;
        }

        public int getCount() {
            return count;
        }
    }
}
