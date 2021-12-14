package com.binod.serialization.secondExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

    public static void main(String[] args) {

        Student student = new Student("BinodSingh", "durgapur", "gvhjvgkgk",
                12345678, 9475665, 8200);

        Student.totalFee = 2500.0;
        Student.titleName = "Kumar";
        System.out.println(student);

        Employee employee = new Employee();
        employee.eid = 111;
        employee.ename = "Neha";

        System.out.println(employee);

        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\binod.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student);
            objectOutputStream.writeObject(employee);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}