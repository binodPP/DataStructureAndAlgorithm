package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindAllPairCountWhoseValueIsSame {

    public static void main(String[] args) {
        int[] array={1,2,3,1,2,3,2,1,2,4};
        //output: 1 has 1 valid pair, 2 has 2 valid pair, 3 has 1 valid pair, 4 has no pair
        // so output is 1-> 1, 2->2, 3-> 1
        findPair(array);
    }

    public static void findPair(int[] array){
        HashMap hashMap = new HashMap();
        for(int i =0; i < array.length; i++){
            if(hashMap.containsKey(array[i])){
                hashMap.put(array[i],(Integer)hashMap.get(array[i])+1);
            }else {
                hashMap.put(array[i],1);
            }
        }
        Set<Map.Entry> entries=hashMap.entrySet();
        for (Map.Entry entry: entries){
            if((Integer)entry.getValue()/2 !=0) {
                System.out.println(entry.getKey() + ", count = " + (Integer) entry.getValue() / 2);
            }

        }
    }
}
