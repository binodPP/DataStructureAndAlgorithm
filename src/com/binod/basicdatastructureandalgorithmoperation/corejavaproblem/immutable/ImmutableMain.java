package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.immutable;

public class ImmutableMain {
    public static void main(String[] args) {

        //Immutable test before creating the cole object of Age class, immutability will fail
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        ImmutableStudent student = new ImmutableStudent(1, "Alex", age);


        System.out.println("Alex age year before modification = " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Alex age year after modification = " + student.getAge().getYear());


        //Step 2
        System.out.println("Alex age year before modification step 2= " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Alex age year after modification step 2= " + student.getAge().getYear());


        //Ste3
        System.out.println("Alex age year before modification step 3 = " + student.getAge().getYear());
        student.getAge().setYear(1993);
        System.out.println("Alex age year after modification step 3= " + student.getAge().getYear());



    }
}
