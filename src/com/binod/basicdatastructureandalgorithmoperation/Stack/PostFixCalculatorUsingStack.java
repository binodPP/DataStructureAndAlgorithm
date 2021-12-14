package com.binod.basicdatastructureandalgorithmoperation.Stack;

import java.util.Stack;

public class PostFixCalculatorUsingStack {

    private static int postfixCalculator(String exp1){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < exp1.length() ; i++) {
            char charValue = exp1.charAt(i);
            if(Character.isDigit(charValue)){
                stack.push(Integer.parseInt(String.valueOf(charValue)));
            }else{
                int val1=stack.pop();
                int val2=stack.pop();
                switch (charValue){
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                }

            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        InfixToPostFixUsingStackImplementation infixToPostFix=new InfixToPostFixUsingStackImplementation();
        String expInfix="2+(3*1)-9";;
        String expPostfix="231*+9-";
        System.out.println("postfix calculator evaluation: "+postfixCalculator(infixToPostFix.infixToPostfix(expInfix)));
        System.out.println("postfix calculator evaluation: "+postfixCalculator(expPostfix));
    }
}