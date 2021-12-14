package com.binod.basicdatastructureandalgorithmoperation.string;

import java.util.Stack;

public class StringStack {
    //input: "...xx..xx..xxx.."
    //output: ".........xxxxxxx"
    public static void main(String[] args) {
        String str="...xx..xx..xxx..";
        String result="";
        Stack<Character> characters= new Stack<>();
        for(int i=0; i < str.length(); i++){
            char c= str.charAt(i);
            if(c == 'x'){
                characters.push(c);
            }else {
                result= result+c;
            }
        }

        while(!characters.empty()){
            result+=characters.pop();
        }

        System.out.println(result);
    }
}
