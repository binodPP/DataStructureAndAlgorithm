package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.secondExample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationTest {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("D:\\binod.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            Student student=(Student)objectInputStream.readObject();
            Employee employee=(Employee)objectInputStream.readObject();
            System.out.println(student);
            System.out.println(employee);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
