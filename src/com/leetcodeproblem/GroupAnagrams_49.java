package com.leetcodeproblem;

import java.util.*;
//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams11(strs));
    }

    //Time Complexity: O(n) * n log k) + O(n) (k is the length of largest string)
    //Space Complexity: O(n)+O(n)
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



    //OPTION-2
    public static List<List<String>> groupAnagrams11(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            String signature = getSignature(s);
            groups.putIfAbsent(signature, new ArrayList<>());
            groups.get(signature).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    private static String getSignature(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
