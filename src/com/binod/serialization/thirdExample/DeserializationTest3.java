package com.binod.serialization.thirdExample;

import com.binod.serialization.secondExample.Employee;
import com.binod.serialization.secondExample.Student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationTest3 {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("D:\\binod1.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            Student student=(Student)objectInputStream.readObject();
            System.out.println(student);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
