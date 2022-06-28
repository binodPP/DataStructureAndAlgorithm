package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.thirdExample;

public class Address {
    int aid;
    String street;

    public Address(){
        System.out.println("Address Constructor call.....");
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", street='" + street + '\'' +
                '}';
    }
}
