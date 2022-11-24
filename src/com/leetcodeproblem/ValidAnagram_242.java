package com.leetcodeproblem;

import java.util.Arrays;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "aatta";
        String t = "atta";

        System.out.println(isAnagram(s, t));
    }

    //TC:O(N),SC: O(26)=O(1)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];
        Arrays.fill(array, 0);
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            array[t.charAt(j) - 'a']--;

            if (array[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
