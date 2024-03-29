package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/fizz-buzz/
public class FizzBuzzProb_412 {
    public static void main(String[] args) {
        int n=15;
        System.out.println(fizzBuzz(n));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list= new ArrayList<>();
        for(int i =1; i<=n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
