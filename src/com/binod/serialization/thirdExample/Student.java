package com.binod.serialization.thirdExample;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student extends Person implements Externalizable {
    int sid;
    transient long phone;
    double fee;
    static double totalFee=1600.0;
    static String titleName="Singh";
    transient Address add=null;

    public Student(){}

    public Student(String name, int sid, long phone, double fee, Address add){
        System.out.println("Student Constructor call..");
        this.sid = sid;
        this.name = name;
        this.phone=phone;
        this.fee=fee;
        this.add=add;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        sid=in.readInt();
        name=in.readObject().toString();
        phone=in.readLong();
        totalFee=in.readDouble();
        titleName=in.readObject().toString();
        int aid=in.readInt();
        String str=in.readObject().toString();
        add=new Address();
        add.aid=aid;
        add.street=str;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(sid);
        out.writeObject(name);
        out.writeLong(phone);
        out.writeObject(titleName);
        out.writeDouble(totalFee);
        out.writeInt(add.aid);
        out.writeObject(add.street);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", phone=" + phone +
                ", fee=" + fee +
                ", totalFee='" + totalFee + '\'' +
                ", titleName='" + titleName + '\'' +
                ", Add Info ='" + add + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
