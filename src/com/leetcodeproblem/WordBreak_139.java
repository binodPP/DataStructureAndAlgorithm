package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
    public static void main(String[] args) {
    String s = "leetcode";
    List<String> wordDict= new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }

    //DP Prob : TimeComplexity = O(n square 2), space complexity= O(n)
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        Boolean[] dp= new Boolean[len+1];
        Arrays.fill(dp,false);
        dp[0]=true;

        for(int i=1; i<=len; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
