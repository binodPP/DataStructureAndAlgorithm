package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.secondExample;

import java.io.Serializable;

public class Employee implements Serializable {

    int eid;
    String ename;

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                '}';
    }
}
