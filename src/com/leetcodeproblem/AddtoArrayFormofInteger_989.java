package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger_989 {
    //https://leetcode.com/problems/add-to-array-form-of-integer/
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> integerList= new ArrayList<>();
        //Method 1 : with one loop
        for(int i = A.length-1; i>=0;i--){
            K=K+A[i];
            integerList.add(K%10);
            K=K/10;
        }
        Collections.reverse(integerList);
         return integerList;

        //Method 2: with two loop
        /*for(int i = A.length-1; i>=0;i--){
            K=K+A[i];
            integerList.add(K%10);
            K=K/10;
        }
        while(K>0){
            integerList.add(K%10);
            K=K/10;
        }
        Collections.reverse(integerList);
        return integerList;*/
    }

    public static void main(String[] args) {
        int[] num={1,2,0,0};
        int k = 34;
        System.out.println("Aarray list : " + addToArrayForm(num,k));
    }
}