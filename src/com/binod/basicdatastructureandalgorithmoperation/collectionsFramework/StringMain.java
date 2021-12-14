package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringMain {
    public static void main(String[] args) {
        String str="[1,2,3]";
        Pattern pattern = Pattern.compile(",");
        String[] str1=pattern.split(str);
        System.out.println(str1);
        List list= new ArrayList<>();
        for(int i=0; i <str1.length; i++){
                list.add(str1[i]);
        }

        System.out.println(list);
    }
}
