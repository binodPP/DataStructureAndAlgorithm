package com.leetcodeproblem.two_d_array_matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixToZero_73 {
    //https://leetcode.com/problems/set-matrix-zeroes/
    public static void main(String[] args) {
        int[][] array={{1,1,1},{1,0,1},{1,1,1}};
        int row=array.length;
        int column=array[0].length;

        //setMatrixToZeroRowColumn(array,row,column);
        setMatrixToZeroRowColumnWithSpaceComplexity(array,row,column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Option-1 with TimeComplexity=O(m*n) and Space Complexity=O(m+n)
    public static int[][] setMatrixToZeroRowColumn(int[][] array,int row, int column){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet= new HashSet<>();
        for(int i=0; i<row;i++){
            for(int j=0; j<column;j++){
                if(array[i][j]==0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i=0; i<row;i++){
            for(int j=0; j<column;j++){
                if(rowSet.contains(i) || columnSet.contains(j)){
                    array[i][j]=0;
                }
            }
        }

        return array;

    }

    //Option-2 with TimeComplexity=O(m*n) and Space Complexity=O(1)
    public static int[][] setMatrixToZeroRowColumnWithSpaceComplexity(int[][] array,int row, int column){
        boolean colFlag = false;
        for(int i=0; i<row;i++){
            if(array[i][0]==0) {
                colFlag = true;
            }
            for(int j=1; j<column;j++){
                    if(array[i][j]==0){
                        array[i][0]=array[0][j]=0;
                    }
            }
        }

        for(int i=row-1; i>=0;i--){
            for(int j=column-1; j>=1;j--){
                if(array[i][0]==0 || array[0][j]==0){
                    array[i][j]=0;
                }
            }
            if(colFlag){
                array[i][0]=0;
            }
        }

        return array;

    }

}
