package com.leetcodeproblem;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    //Time Complexity: O(n * \log k)O(n∗logk) (k is the length of largest string)
    //Space Complexity: O(n)O(n)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key= String.valueOf(chars);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List list1= new ArrayList();
                list1.add(str);
                map.put(key,list1);
            }
        }

        for(String key: map.keySet()){
            list.add(map.get(key));
        }

        return list;
    }
}
