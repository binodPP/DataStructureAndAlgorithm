package com.binod.serialization.secondExample;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

public class User extends Person implements Serializable {
    String uname;
    transient String password="123456";

    public User(){
        System.out.println("User Constructor call .......");
    }
}
