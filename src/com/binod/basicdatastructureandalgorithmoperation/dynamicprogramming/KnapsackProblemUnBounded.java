package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class KnapsackProblemUnBounded {

    public static void main(String[] args) {

        int[] wt = {1, 2, 3, 5};
        int[] pr = {1, 4, 7, 10};

        int capacity = 8;

        System.out.println(KnapsackProblemUnBounded.getMaximumProfitsOption1(wt, pr, capacity));

    }

    //Option-1
    public static int getMaximumProfitsOption1(int[] wt, int[] pr, int capacity){

        if(wt.length == 0 || pr.length ==0 || capacity <=0){
            return 0;
        }

        int array[][]=new int[wt.length][capacity+1];

        for (int i=0;i < wt.length; i++){
            for(int j = 0; j <= capacity; j++){
                int includeRecords=0;
                int excludeRecords=0;
                if(wt[i] <= j){
                    includeRecords=pr[i]+array[i][j-wt[i]];
                }
                if(i>0) {
                    excludeRecords = array[i - 1][j];
                }
                array[i][j]=Math.max(includeRecords,excludeRecords);
            }
        }

        return array[wt.length-1][capacity];
    }
}
