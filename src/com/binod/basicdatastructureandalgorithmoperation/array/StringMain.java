package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.ArrayList;
import java.util.List;

public class StringMain {

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("MERCH_ADMIN_USER");
        StringBuffer stringBuffer = new StringBuffer();
        for (String r: list) {
            stringBuffer.append("Merchant admin").append(", ");
        }
        stringBuffer.delete(stringBuffer.lastIndexOf(", "),stringBuffer.length());
        System.out.println(stringBuffer.toString());
    }

}
