package com.binod.basicdatastructureandalgorithmoperation.string;

import java.util.regex.Pattern;

public class ReverseTheStringByWorld {
    public static void main(String[] args) {
        String str= "I am from Bihar";
        String result="";
        Pattern pattern = Pattern.compile("\\s");
        String[] temp = pattern.split(str);

        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        System.out.println(result);
        String result1="";
        for (int i = temp.length-1; i >= 0; i--) {
            result1= result1 +" "+ temp[i];
        }

        System.out.println(result1);
    }
}
