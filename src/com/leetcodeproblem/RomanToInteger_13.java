package com.leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

    //https://leetcode.com/problems/roman-to-integer/

    public static void main(String[] args) {
        //String s="MCMXCIV";
        String s="LVIIV";

        System.out.println(romanToInt(s));
        System.out.println(romanToIntOption2(s));
    }

    //Option-1 Time Complexity= O(n), Space Complexity= O(1)
    public static int romanToInt(String s) {
       int result=0;

       for(int i=0; i<s.length(); i++){
           int value1=integerValue(s.charAt(i));
           if(i+1<s.length()){
               int value2=integerValue(s.charAt(i+1));
               if(value1>=value2){
                   result=result+value1;
               }else {
                   result=result-value1;
               }
           }else {
               result =result+value1;
           }

       }
       return result;
    }

    //Option-2 Time Complexity= O(n), Space Complexity= O(7) = O(1)
    public static int romanToIntOption2(String s) {

        Map<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--){
            int value1=map.get(s.charAt(i+1));
            int value2=map.get(s.charAt(i));
            if(value2>=value1){
                result=result+value2;
            }else {
                result=result-value2;
            }
        }
        return result;
    }

    public static int integerValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }
    }
}
