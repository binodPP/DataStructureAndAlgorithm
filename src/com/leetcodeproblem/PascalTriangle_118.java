package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    //https://leetcode.com/problems/pascals-triangle/
    public static void main(String[] args) {

        System.out.println(new PascalTriangle_118().generate(5));
    }

    //Time Complexity=O(n) and space = O(n) . here i have used 2d Matrix logic using row and column
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result= new ArrayList<>();
        List<Integer> row=null;
        List<Integer> prevRow=null;
        for(int i=0; i<numRows;i++) {
            row = new ArrayList<>();
            for (int column = 0; column <= i; column++){
                //add first and last index of each row as 1
                if(column==0 || column==i){
                    row.add(1);
                }else {
                    row.add(prevRow.get(column-1)+prevRow.get(column));
                }
            }
            prevRow=row;
            result.add(row);
        }
        return result;
    }
}
