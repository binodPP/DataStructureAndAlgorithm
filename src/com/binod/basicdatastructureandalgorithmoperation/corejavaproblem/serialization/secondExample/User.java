package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.secondExample;

import java.io.Serializable;

public class User extends Person implements Serializable {
    String uname;
    transient String password="123456";

    public User(){
        System.out.println("User Constructor call .......");
    }
}
