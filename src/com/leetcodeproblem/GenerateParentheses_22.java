package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    //https://leetcode.com/problems/generate-parentheses/
    //https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/

    //Using backtracking recursion problem pattern

    public static void main(String[] args) {
        int n=3;

        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list= new ArrayList<>();
        generateParenthesisRecursiveCall(list,"",n, 0,0);

        return list;
    }

    //TC: O(2^n), SC: O(n)
    public static void generateParenthesisRecursiveCall(List<String> list,String str,int n,
                                                                int openParenthesis, int closeParenthesis) {
        if(openParenthesis == n &&  closeParenthesis == n){
            list.add(str);
            return;
        }

        if(openParenthesis < n){
            generateParenthesisRecursiveCall(list,str+"(",n,openParenthesis+1,closeParenthesis);
        }

        if(closeParenthesis < openParenthesis){
            generateParenthesisRecursiveCall(list,str+")",n,openParenthesis,closeParenthesis+1);
        }

    }
}
