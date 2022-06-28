package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.firstExample;

import java.io.Serializable;

public class Student implements Serializable {
    int sid;
    String name;
    int age;
    static double fee=1600.0;

    public Student(int sid, String name, int age){
        System.out.println("Student Constructor call..");
        this.sid = sid;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", fee=" + fee +
                '}';
    }
}
