package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.firstExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeStudentTest {
    public static void main(String[] args) {
        Student student = new Student(111,"Binod", 33);
        Student.fee=2500.0;
        System.out.println(student);

        try(FileOutputStream fileOutputStream = new FileOutputStream("stud.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
