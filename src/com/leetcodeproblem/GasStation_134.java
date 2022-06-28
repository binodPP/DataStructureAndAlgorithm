package com.leetcodeproblem;

public class GasStation_134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
       int post=-1;
       int current=0;
       int total=0;

       for(int i=0; i<gas.length; i++){
           int diff=gas[i]-cost[i];
           current= current+ diff;
           total = total + diff;

           if(current < 0){
               current=0;
               post=i;
           }
       }

       if(total >=0){
           return post+1;
       }
       return -1;
    }
}
