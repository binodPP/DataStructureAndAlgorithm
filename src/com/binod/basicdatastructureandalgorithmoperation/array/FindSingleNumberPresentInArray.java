package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.HashMap;
import java.util.Map;

public class FindSingleNumberPresentInArray {
    //https://www.tutorialcup.com/interview/algorithm/single-number.htm
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 5, 2, 1, 3};
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0; i < a.length; i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else {
                map.put(a[i],1);
            }
        }

        for (Map.Entry entry:map.entrySet()) {
            if((Integer)entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }
    }
}
