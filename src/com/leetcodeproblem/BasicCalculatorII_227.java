package com.leetcodeproblem;

import java.util.Stack;
//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII_227 {
    public static void main(String[] args) {
      String s = "31+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int multiplyAndDivide= -1; // if 0 then do multiply or if 1 then do divide
        int sign =1; // if 1 the do add or if -1 the do subtract
        int result =0;
        int prev=0;

        for(int i=0; i< s.length(); i++){

            char c= s.charAt(i);
            if(Character.isDigit(c)){
                int num = c -'0';

               /* while(++i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                }
               i--; //back to previous index*/

                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
               if(multiplyAndDivide == 0){
                    prev = prev * num;
                    multiplyAndDivide =-1;
                }else if(multiplyAndDivide == 1) {
                   prev = prev / num;
                   multiplyAndDivide = -1;
               }else {
                   prev = num;
               }
            }else if(c == '/'){
                multiplyAndDivide =1;
            }else if(c == '*'){
                multiplyAndDivide = 0;
            }else if(c == '+'){
                result = result + sign * prev;
                sign = 1;
            }else if(c == '-'){
                result = result + sign * prev;
                sign = -1;
            }
        }

        result = result + sign * prev;

        return  result;
    }
}
