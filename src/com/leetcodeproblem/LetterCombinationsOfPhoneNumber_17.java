package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_17 {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    public static void main(String[] args) {
        String digits = "23";
        List<String> list=letterCombinations(digits);
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list= new ArrayList<>();
        Map<String,String> map= new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        if(digits == null || digits.length() ==0) {
            return list;
        }

        letterCombinationUsingRecursivePattern(list,map,digits,"",0);

        return list;
    }

    //Time Complexity: O(4^n) as we get set of all possible numbers of length n. In worst case, for each number there can be 4 possibilities.
    //Auxiliary Space: O(4^n)
    public static void letterCombinationUsingRecursivePattern(List<String> list,Map<String,String> map,String digits,
                                                 String current, int index){
        if(index ==digits.length()){
            list.add(current);
            return;
        }

        String letter=map.get(digits.charAt(index)+"");

        for (int i=0; i<letter.length();i++){
            letterCombinationUsingRecursivePattern(list,map,digits,current+letter.charAt(i),index+1);
        }
    }
}
