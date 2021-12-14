package com.binod.serialization.firstExample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationStudentTest {
    public static void main(String[] args) {

        System.out.println("Start deserialization process for student class");

        try(FileInputStream fileInputStream = new FileInputStream("D:\\stud.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            Object obj = objectInputStream.readObject();

            System.out.println("Class name : " + obj.getClass().getName());
            if(obj instanceof Student){
                Student student = (Student)obj;
                System.out.println(student.sid);
                System.out.println(student.age);
                System.out.println(student.name);
                System.out.println(Student.fee);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
