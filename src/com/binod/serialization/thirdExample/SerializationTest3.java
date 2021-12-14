package com.binod.serialization.thirdExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationTest3 {
    public static void main(String[] args) {
        Address address= new Address();
        address.aid=111;
        address.street="Bangalore";

        Student student= new Student("Binod",1234,88888888,25000.0,address);

        Student.titleName="Kumar";
        Student.totalFee=1200.0;
        System.out.println(student);

        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\binod1.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
