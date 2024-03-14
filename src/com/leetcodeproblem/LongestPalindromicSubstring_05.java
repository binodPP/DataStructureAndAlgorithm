package com.leetcodeproblem;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring_05 {
    int start =0; int end=0;
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring_05().longestPalindrome(s));
    }

    //TC: O(N*N) , SC: O(1)
    public String longestPalindrome(String s) {

        for(int i=0; i< s.length(); i++){
            //By calling expandSubstring with different initial boundaries (i and i + 1), the code is able
            // to cover both cases of palindromes (odd and even lengths)
            expandSubstring(s,i,i);
            expandSubstring(s,i,i+1);
        }
        return s.substring(start,end+1);
    }

    public  void expandSubstring(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        //n the provided code snippet, the lines left = left + 1; and right = right - 1; are used after the while loop in the expandSubstring method. These lines adjust the left and right indices to represent the boundaries of the longest palindromic substring found.
        //
        //Let's break down why we perform these adjustments:
        //
        //Left Boundary Adjustment (left = left + 1):
        //
        //In the while loop, when we find a palindrome, the left index is decremented until it no longer satisfies the condition (left >= 0 && s.charAt(left) == s.charAt(right)).
        //After the while loop, the left index will be one position to the left of the actual left boundary of the palindrome. This is because the loop exits when left becomes less than 0 or the characters at left and right are not equal.
        //To adjust for this, we increment the left index by 1, moving it to the actual left boundary of the palindrome.
        //Right Boundary Adjustment (right = right - 1):
        //
        //Similar to the left boundary adjustment, in the while loop, the right index is incremented until it no longer satisfies the condition (right < s.length() && s.charAt(left) == s.charAt(right)).
        //After the while loop, the right index will be one position to the right of the actual right boundary of the palindrome. This is because the loop exits when right becomes equal to or greater than the length of the string s or the characters at left and right are not equal.
        //To adjust for this, we decrement the right index by 1, moving it to the actual right boundary of the palindrome.

        left = left+1;
        right = right-1;

        if(end - start +1 < right - left +1){
            start = left;
            end = right;
        }

    }
}
