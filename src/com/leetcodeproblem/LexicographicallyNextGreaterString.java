package com.leetcodeproblem;

//https://www.geeksforgeeks.org/lexicographically-next-string/
public class LexicographicallyNextGreaterString {

    //Time Complexity: O(n)
    //Auxiliary Space: O(1)
    public static String nextWord(String str)
    {
        // if string is empty
        if (str == "")
            return "a";

        // Find first character from
        // right which is not z.
        int i = str.length() - 1;
        while (str.charAt(i) == 'z' && i >= 0) {
            i--;
        }

        // If all characters are 'z',
        // append an 'a' at the end.
        if (i == -1) {
            str = str + 'a';
        }

        // If there are some
        // non-z characters
        else {
            str = str.substring(0, i) +
                    (char) ((int) (str.charAt(i)) + 1) +
                    str.substring(i + 1);
        }
        return str;
    }

    // Driver Code
    public static void main (String[] args)
    {
        String str = "raavz";
        System.out.print(nextWord(str));
    }
}
