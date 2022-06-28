package com.leetcodeproblem;

public class MinimumDominoRotationsForEqualRow_1007 {
    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2}, bottoms = {5,2,6,2,3,2};
        System.out.println(minDominoRotations(tops,bottoms));
    }


    public static int minDominoRotations(int[] tops, int[] bottoms) {
       //for(int value=1;value<=6;value++){
           int current=minRotationHelper(tops,bottoms,tops[0]);
           if(current !=-1 || tops[0] == bottoms[0]){
               return current;
           }else {
               return minRotationHelper(tops,bottoms,bottoms[0]);
           }
    }

    private static int minRotationHelper( int[] tops,int[] bottoms, int value){
        int topRotationResult=0;
        int bottomRotationResult=0;
          for(int i=0; i< tops.length; i++){
              if(tops[i] != value && bottoms[i] != value){
                  return -1;
              }else if (tops[i] != value){
                  topRotationResult++;
              }else if (bottoms[i] != value){
                  bottomRotationResult++;
              }
          }
        return Math.min(topRotationResult,bottomRotationResult);
    }
}
