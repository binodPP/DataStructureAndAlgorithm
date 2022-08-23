package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

//https://leetcode.com/problems/super-egg-drop/

import java.util.Arrays;

//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
public class SuperEggDrop_887 {
    public static void main(String[] args) {
        int egg=5;
        int floor=10000;
        System.out.println(new SuperEggDrop_887().superEggDrop(egg,floor));
    }

    public int superEggDrop(int k, int n) {
        int[][] result = new int[k+1][n+1];
        Arrays.stream(result).forEach(a -> Arrays.fill(a, -1));

        return superEggDropHelper(result, k,n);
    }

    public int superEggDropHelper(int[][] result, int k, int n) {
        if(k==1){
            return n;
        }
        if(n == 0 || n == 1){
            return n;
        }

        if(result[k][n] != -1){
            return result[k][n];
        }
        int finalResult= Integer.MAX_VALUE;
        for(int i=1; i<= n ; i++){
            int temp = Math.max(superEggDropHelper(result,k-1,i-1),superEggDropHelper(result,k,n-i));
            finalResult = Math.min(finalResult,temp);
        }

        result[k][n]= finalResult+1;

        return finalResult+1;
    }
}
