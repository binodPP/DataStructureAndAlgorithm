package com.leetcodeproblem.two_d_array_matrix;
//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchTwoDMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrixPattern1(matrix,target));
        //System.out.println(searchMatrixPattern2(matrix,target));
       // System.out.println(searchMatrixPattern3(matrix,target));
    }

    //Pattern-1, binary Search, Time complexity=O(log(m) + log(n)), space complexity=O(1)
    public static boolean searchMatrixPattern1(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int low=0; int high=matrix.length-1;
        int targetIndex=-1;
        //Binary search on row
        while(low <=high){
            int mid = low + (high-low)/2;
            if(matrix[mid][matrix[0].length-1] == target) {
                return true;
            } else if(matrix[mid][matrix[0].length-1] < target) {
                low = mid + 1;
            }
            else {
                targetIndex= mid;
                high = mid - 1;
            }
        }

        if(targetIndex==-1){
            return false;
        }


        int low1=0; int high1=matrix[0].length-1;
        //Binary search on column
        while(low1 <=high1){
            int mid = low1 + (high1-low1)/2;
            if(matrix[targetIndex][mid] == target) {
                return true;
            } else if(matrix[targetIndex][mid] < target) {
                low1 = mid + 1;
            }
            else {
                high1 = mid - 1;
            }
        }

        return false;
    }

    //Pattern-2, Remove row col in each comparison, Time complexity=O(m + n), space complexity=O(1)
    public static boolean searchMatrixPattern2(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int row=0; int col=m-1;
        while(row < n && col >= 0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row = row + 1;
            else
                col = col - 1;
        }
        return false;
    }

    //Pattern-3, Linear traversal, Time complexity=O(m*n), space complexity=O(1)
    public static boolean searchMatrixPattern3(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
