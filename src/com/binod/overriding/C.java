package com.binod.overriding;

import com.binod.overriding.A;

public class C extends A {
    protected String str="Binod22";
    public void display(Integer integer){
        System.out.println("Subclass c");
    }

    public void display(String s){
        System.out.println("Subclass c");
    }
}
