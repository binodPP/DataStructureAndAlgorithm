package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class KnapsackProblemBounded {
    public static void main(String[] args) {

        int[] wt = {1, 2, 3, 5};
        int[] pr = {1, 4, 7, 10};

        int capacity = 8;

        System.out.println(KnapsackProblemBounded.getMaximumProfitsOption1(wt, pr, capacity));

    }

    //Option-1
    public static int getMaximumProfitsOption1(int[] wt, int[] pr, int capacity){

        if(wt.length == 0 || pr.length ==0 || capacity <=0){
            return 0;
        }

        int array[][]=new int[wt.length][capacity+1];

        for(int j =0; j <= capacity ; j++) {
            if (wt[0] <= capacity){
                array[0][j]=pr[0];
            }
        }

        for (int i=1;i < wt.length; i++){
            for(int j = 1; j <= capacity; j++){
                int includeRecords=0;
                if(wt[i] <= j){
                    includeRecords=pr[i]+array[i-1][j-wt[i]];
                }
                int excludeRecords=array[i-1][j];
                array[i][j]=Math.max(includeRecords,excludeRecords);
            }
        }

        return array[wt.length-1][capacity];
    }
}
