package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem;

public class StringMain {


    public static void main(String[] args) {
        String str= "Binod";
        String str1= "Binod";

        String str4 = new String("Binod");
        String str5 = new String("Binod");

        System.out.println(str == str1);
        System.out.println(str == str4);
        System.out.println(str.equalsIgnoreCase(str1));
        System.out.println(str4 == str5);
        System.out.println(str4.equalsIgnoreCase(str5));
        System.out.println(str.equalsIgnoreCase(str4));
    }


}
