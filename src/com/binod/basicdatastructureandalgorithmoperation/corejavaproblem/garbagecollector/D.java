package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.garbagecollector;

import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.overriding.A;

public class D extends A{
    //String str="Binod";
    public void display(){
        System.out.println("Constructor D");
    }

    public static void main(String[] args) {
        A a= new D();
        D d= new D();
        System.out.println(d.str);
        //System.out.println(a.str);
    }
}
