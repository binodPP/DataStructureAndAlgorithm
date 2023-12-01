package com.binod.basicdatastructureandalgorithmoperation.string;

import java.util.Arrays;

public class PrintAllPermutationsOfAString {
    public static void main(String[] args) {
        String str="AAB";
        //getPermutationOfString(str,0, str.length()-1);
        permute(str,"");
        findLexicographic(str);
    }

    //Method 1:TC: O(n*n!), SC : O(r – l)
    public static void getPermutationOfString(String str, int start, int end){

        if(start == end){
            System.out.println(str);
        }

        for(int i=1; i<=end; i++){
            str = swap(str,start,i);
            getPermutationOfString(str,start+1, end);
            str = swap(str, start, i);
        }

    }

    public static String swap(String str, int i, int j){
        char[] chars= str.toCharArray();

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return String.valueOf(chars);
    }

    //Method 2: TC: O(n*n!), SC : O(r – l)
    static void permute(String s , String answer)
    {
        if (s.length() == 0)
        {
            System.out.print(answer + "  ");
            return;
        }

        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }


    public static void lexicographic(char[] chars, String res)
    {
        // base condition (permutation found)
        System.out.println(" ");
        if (res.length() == chars.length)
        {
            // print the permutation and return
            System.out.print(res + " ");
            return;
        }

        // consider all characters of the string one by one
        for (int i = 0; i < chars.length; i++)
        {
            // skip adjacent duplicates
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
            }

            lexicographic(chars, res + chars[i]);
        }
    }

    // Wrapper over `lexicographic()` function
    public static void findLexicographic(String str)
    {
        // base case
        if (str == null || str.length() == 0) {
            return;
        }

        // sort the string to print in lexicographical order
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        lexicographic(chars, "");
    }

}
