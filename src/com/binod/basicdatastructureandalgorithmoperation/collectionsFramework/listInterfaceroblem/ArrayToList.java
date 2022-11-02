package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework.listInterfaceroblem;

import java.util.ArrayList;

public class ArrayToList<E> implements MyList<E>{
    private ArrayList<E> arrayToList;

    public ArrayToList(){
        arrayToList= new ArrayList<>();
    }

    @Override
    public void convert(E element) {
        arrayToList.add(element);
        String str= "I have added String:{String} at index:{index}";
        String index = String.valueOf(arrayToList.indexOf(element));
        System.out.println(str.replace("{String}", (String)element).replace("{index}",index));
    }

    @Override
    public void replace(int index) {

    }

    @Override
    public ArrayList<E> compact() {
        return null;
    }
}
