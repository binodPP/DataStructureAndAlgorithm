package com.binod.basicdatastructureandalgorithmoperation.array;

public class ContainerWithMostWater_11 {
    //https://leetcode.com/problems/container-with-most-water/
    public static void main(String[] args) {
      int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaOption1(height));
    }

    //Option -2, time complexity=O(n), space complexity=O(1);
    public static int maxArea(int[] height) {
        int result=0;
        int start=0;
        int end=height.length-1;

        if(height.length==0 || height.length<2){
            return 0;
        }

        while (start <= end){
            int current_area=(end-start)*Math.min(height[start],height[end]);
            result=Math.max(result,current_area);

            if(height[start] <= height[end]){
                start++;
            }else {
                end--;
            }

        }

        return result;
    }

    //Option -1, time complexity=O(n*n), space complexity=O(1);
    public static int maxAreaOption1(int[] height) {
       int result=0;

       int length=height.length-1;

       if(length==0 || length<2){
           return 0;
       }

       for(int i=0; i<=length; i++){
           for(int j=i; j<=length; j++){
               int current_area=(j-i)*Math.min(height[j],height[i]);
               result=Math.max(result,current_area);
           }
       }
       return result;
    }
}
