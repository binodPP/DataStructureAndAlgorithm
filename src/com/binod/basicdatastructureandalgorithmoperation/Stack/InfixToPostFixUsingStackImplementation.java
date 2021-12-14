package com.binod.basicdatastructureandalgorithmoperation.Stack;

import java.util.Stack;

/*
Algorithm:

        Initialize result as a blank string, Iterate through given expression, one character at a time

        1. If the character is an operand, add it to the result.
        2. If the character is an operator.
           . If the operator stack is empty then push it to the operator stack.
           . Else If the operator stack is not empty,
               . If the operator’s precedence is greater than or equal to the precedence of the stack top of the operator stack,
                 then push the character to the operator stack.
               . If the operator’s precedence is less than the precedence of the stack top of operator stack then
                 “pop out an operator from the stack and add it to the result until the stack is empty or operator’s precedence is greater than or equal to the precedence of the stack top of operator stack“. then push the operator to stack.
        3. If the character is “(“, then push it onto the operator stack.
        4. If the character is “)”, then “pop out an operator from the stack and add it to the result until
           the corresponding “(“ is encountered in operator stack. Now just pop out the “(“.

        Once the expression iteration is completed and the operator stack is not empty,
        “pop out an operator from the stack and add it to the result” until the operator stack is empty.  The result will be our answer,
        postfix expression.
*/

public class InfixToPostFixUsingStackImplementation {

    private int precedence(char char1){
        switch (char1){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public String infixToPostfix(String exp){
        String result="";
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i < exp.length() ; i++ ) {
            char chars=exp.charAt(i);
            if (precedence(chars) > 0){
                while(!stack.isEmpty() && precedence(chars) <= precedence(stack.peek())){
                    result+=stack.pop();
                }
                stack.push(chars);
            }else if(chars == ')'){
                char x = stack.pop();
                 while (!stack.isEmpty() && x != '('){
                     result+=x;
                     x=stack.pop();
                 }
            }else if(chars == '('){
                stack.push(chars);
            }else{
               result+=chars;
            }
        }
        for(int i=0 ; i<stack.size() ; i++){
            result+=stack.pop();
        }
        return result;
    }


    /*public static void main(String[] args){
        InfixToPostFixUsingStackImplementation obj= new InfixToPostFixUsingStackImplementation();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String result=obj.infixToPostfix(exp);
        System.out.println("Post fix result is : " + result);
    }*/
}