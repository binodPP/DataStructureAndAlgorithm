package com.leetcodeproblem.pascaltrainglepattern;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    //https://leetcode.com/problems/pascals-triangle-ii/

    public static void main(String[] args) {

        System.out.println(new PascalTriangleII().getRow(4));

    }

    //Time Complexity=O(n) and space = O(n) . here i have used 2d Matrix logic using row and column
    public List<Integer> getRow(int rowIndex) {
      List<Integer> result;
      List<Integer> prevRow= null;
      int i=0;
      while (i<=rowIndex){
          result= new ArrayList<>();
          for(int column=0; column<=i; column++){
              if(column==0 || column==i){
                  result.add(1);
              }else {
                  result.add(prevRow.get(column-1)+prevRow.get(column));
              }
          }
          prevRow=result;
          if(i==rowIndex){
              return result;
          }
          i++;
      }
      return null;
    }
}
