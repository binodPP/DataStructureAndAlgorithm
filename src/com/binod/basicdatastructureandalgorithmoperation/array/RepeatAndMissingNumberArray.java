package com.binod.basicdatastructureandalgorithmoperation.array;

import com.sun.codemodel.internal.JForEach;

import java.util.*;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);

        ArrayList<Integer> arrayList=new RepeatAndMissingNumberArray().repeatedNumber(list);
        for (Integer integer:arrayList) {
            System.out.println(integer);
        }




    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        Set<Integer> set= new HashSet<>();
        int i=0;
        ArrayList<Integer> arrayList= new ArrayList<>();
        while(i<A.size()){
            if(set.contains(A.get(i))) {
                arrayList.add(A.get(i));
            }else {
                set.add(A.get(i));
            }
            i++;
        }
        

        return arrayList;
    }
}
