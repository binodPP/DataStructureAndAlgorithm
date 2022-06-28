package com.leetcodeproblem;

//https://leetcode.com/problems/plus-one/submissions/
public class AddOneToNumberOrPlusOne {
    //Pattern-1
    public static int[] plusOne(int[] A) {
        for(int i=A.length-1 ; i>=0 ; i--){
            if(A[i] <9){
                A[i]++;
                return A;
            }else{
                A[i]=0;
            }

        }
        int[] finalResult= new int[A.length+1];
        finalResult[0]=1;
        return finalResult;
    }

    public static void main(String[] args) {
        int[] array={0, 3, 7, 5,9};
        //int[] array1={9,9,9};
        int[] result=plusOne(array);
            for (int i = 0; i < result.length; i++) {

                System.out.println(result[i]);
        }
    }
}