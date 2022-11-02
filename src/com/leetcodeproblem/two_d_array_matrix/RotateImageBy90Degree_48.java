package com.leetcodeproblem.two_d_array_matrix;

     //https://leetcode.com/problems/rotate-image/
public class RotateImageBy90Degree_48 {
    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //new RotateImageBy90Degree_48().rotateOption1(arr);
        new RotateImageBy90Degree_48().rotateOption2(arr);
    }

    //Option-1 TimeComplexity= O(n*n) , Space Complexity= O(n*n)
    public void rotateOption1(int[][] matrix) {
        int n= matrix.length;
        int[][] rotated= new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
               rotated[j][n-1-i]=matrix[i][j];
            }
        }

        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }

    //Option-2 TimeComplexity= O(n*n) , Space Complexity= O(1)
        // Approach:

         //Step1: Transpose of the matrix. (transposing means changing columns to rows and rows to columns)

         //Step2: Reverse each row of the matrix.

    public void rotateOption2(int[][] matrix) {
        int n= matrix.length;
        for(int i=0; i<n;i++){
            for(int j=i; j<n; j++){
                 int temp=matrix[i][j];
                 matrix[i][j]=matrix[j][i];
                 matrix[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
               int temp=matrix[i][j];
               matrix[i][j]=matrix[i][n-1-j];
               matrix[i][n-1-j]=temp;
            }
        }

        System.out.println("Transpose the matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
