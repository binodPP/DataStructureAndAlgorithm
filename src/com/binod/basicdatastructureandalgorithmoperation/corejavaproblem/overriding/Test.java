package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.overriding;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        B b= new B();
        A a= new B();
        C c= new C();
        A ac= new C();
        b.display();
        a.display();
        c.display();
        ac.display();
        //c.display(null);
        System.out.println(b.str);
        System.out.println(a.str);
        System.out.println(c.str);

        Emp emp= new Emp(1,"Binod");
        Emp emp2= new Emp(2,"Binod11");

        List<Emp> list= new ArrayList();
        list.add(emp);
        list.add(emp2);

        emp= null;

        System.out.println(list.size());

        for(Emp emp3:list) {
            System.out.println(emp3.getId());
            System.out.println(emp3.getStr());
        }

        Integer i=10;
        Integer j=10;

        Integer k= new Integer(10);

        String str="1";
        String str1="1";
        System.out.println(i.equals(j));
        System.out.println(i==j);
        System.out.println(i==k);

        System.out.println(str.equals(str1));
        System.out.println(str==str1);

        }
}
