package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.creationaldesignpattern.singletondesignpattern;

import java.io.*;

public class SingletonSerializedTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        BillPughSingleton instance1 = BillPughSingleton.getInstanceBillPughSingleton();
        // Serialize the object
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "singleton.ser"));
        out.writeObject(instance1);
        out.close();

        // deserialize the object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "singleton.ser"));
        BillPughSingleton instance2 = (BillPughSingleton) in.readObject();
        in.close();

        System.out.println("Hashcode of instance1: "+instance1.hashCode());
        System.out.println("Hashcode of instance2: "+instance2.hashCode());
    }
}
