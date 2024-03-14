package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.service;

import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.annoation.GreaterThanZero;
import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.annoation.NotEmpty;

public class Person {
    @NotEmpty
    private String name;

    @GreaterThanZero
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
