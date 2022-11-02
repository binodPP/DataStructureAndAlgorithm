package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.immutable;

public final class ImmutableStudent {
    private final int id;
    private final String name;
    private Age age;

    //Here immutability will fail because we are using actual Age class object because java uses pass by value concepts
   /* public ImmutableStudent(int id, String name,Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }*/

    //Here we can use create copy of age class to achieve immutability ,
    //step 2
    public ImmutableStudent(int id, String name,Age age) {
        this.name = name;
        this.id = id;
        Age clonedAge = new Age();
        clonedAge.setDay(age.getDay());
        clonedAge.setMonth(age.getMonth());
        clonedAge.setYear(age.getYear());
        this.age = clonedAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    /*public Age getAge() {
        return age;
    }*/

    //step 3
    public Age getAge() {
        Age clonedAge = new Age();
        clonedAge.setDay(this.age.getDay());
        clonedAge.setMonth(this.age.getMonth());
        clonedAge.setYear(this.age.getYear());
        return clonedAge;
    }
}
