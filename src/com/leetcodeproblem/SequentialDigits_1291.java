package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_1291 {
    public static void main(String[] args) {
        int low = 100, high = 300;
        System.out.println(sequentialDigits(low,high));
    }

    //TimeComplexity= O(8*8)->0(64)->O(1), space complexity= O(1)
    public static List<Integer> sequentialDigits(int low, int high) {
      List<Integer> list= new ArrayList<>();
      String s="123456789";

      for(int i=1; i<=s.length();i++){
          for (int j=0;j<=s.length()-i;j++){
              String str = s.substring(j,j+i);
              int digit = Integer.parseInt(str);
              if(digit > high){
                  break;
              }
              System.out.println(str);
              if(digit >= low && digit <=high){
                  list.add(digit);
              }
          }
      }
      return list;
    }
}
