package com.leetcodeproblem;

//https://www.tutorialcup.com/interview/string/calculate-sum-of-all-numbers-present-in-a-string.htm
//https://takeuforward.org/data-structure/sum-of-the-numbers-in-a-string/
public class SumOfNumbersInString {
    public static void main(String[] args) {
     String s="a123b12c1d";
        System.out.println(getSumInAString(s));
    }

    public static int getSumInAString(String s){
        int result=0;
        for(int i=0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int num= s.charAt(i)-'0';
                //s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'  or Character.isDigit(s.charAt(i+1)
                while(i+1< s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10+s.charAt(i+1)-'0';
                    i++;
                }
                result= result+num;
            }
        }

        return result;
    }
}
