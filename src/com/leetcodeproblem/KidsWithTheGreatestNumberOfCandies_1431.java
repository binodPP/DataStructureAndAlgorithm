package com.leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithTheGreatestNumberOfCandies_1431 {
    public static void main(String[] args) {
        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        System.out.println(kidsWithCandies(candies,extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
          List<Boolean> list = new ArrayList<>();
          int max = 0;

          for(int i=0; i< candies.length; i++){
              max= Math.max(max,candies[i]);
          }

          for(int j=0; j< candies.length; j++){
              if(extraCandies+candies[j] >= max){
                  list.add(true);
              }else {
                  list.add(false);
              }
          }

          return list;
    }
}
