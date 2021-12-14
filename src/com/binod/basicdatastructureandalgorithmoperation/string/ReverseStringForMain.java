package com.binod.basicdatastructureandalgorithmoperation.string;

public class ReverseStringForMain {
    //Java program to reverse a String
    public static void main(String[] args) {
        String str = "java2blog";
        String reverse="";
        for(int i = str.length()-1;i >=0; i--){
            reverse = reverse+str.charAt(i);
        }
        System.out.println(reverse);
    }
}
