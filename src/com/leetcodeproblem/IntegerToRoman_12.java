package com.leetcodeproblem;

import java.util.HashMap;
import java.util.TreeMap;

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman_12 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1000,"M");
        map.put(500,"D");
        map.put(100,"C");
        map.put(50,"L");
        map.put(10,"X");
        map.put(5,"V");
        map.put(1,"I");
        int num= 39;

        System.out.println(intToRoman(num,map));

        int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int num1=39;

        System.out.println(intToRoman1(num1, bases, roman));

    }

    //TC: O(N), ASC: O(N)
    public static String intToRoman(int num, TreeMap<Integer,String> map) {

        int number = map.floorKey(num);
        if(number == num){
            return map.get(number);
        }

        return map.get(number) + intToRoman(num - number,map);

    }

    //TC: O(N*N), ASC: O(1)
    public static String intToRoman1(int num, int[] base, String[] roman) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i =0 ; i< base.length ; i++){

            while(num >= base[i]){
                stringBuilder.append(roman[i]);
                num = num - base[i];
            }
        }
        return stringBuilder.toString();
    }

}
