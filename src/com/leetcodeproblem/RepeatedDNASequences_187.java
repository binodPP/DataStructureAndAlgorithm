package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences_187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<= s.length()-10;i++){
            String subString = s.substring(i,i+10);
            map.put(subString, map.getOrDefault(subString,0)+1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()>1){
                list.add(entry.getKey());
            }
        }

        return list;
    }

}
