package com.leetcodeproblem.two_d_array_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
      int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix).stream().forEach(System.out::println);
    }

    //Pattern-1 Time complexity=O(m * n), space complexity=O(1) if we exclude output list and if we
    // include output list then O(n)
    public static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> list= new ArrayList<>();
      if(matrix.length==0){
          return list;
      }
      int r1=0;
      int r2=matrix.length-1;
      int c1=0;
      int c2= matrix[0].length-1;

      while(r1<=r2 && c1<=c2){
          for(int i=c1; i<=c2; i++){
              list.add(matrix[r1][i]);
          }

          for(int j = r1+1; j <=r2; j++){
              list.add(matrix[j][c2]);
          }

          if(r1<r2 && c1<c2) {
              for (int i = c2 - 1; i > c1; i--) {
                  list.add(matrix[r2][i]);
              }

              for (int j = r2; j > r1; j--) {
                  list.add(matrix[j][c1]);
              }
          }

          r1++; r2--;c1++; c2--;
      }

      return list;
    }
}
