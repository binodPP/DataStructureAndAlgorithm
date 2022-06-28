package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.serialization.secondExample;

public class Student extends User {
    int sid;
    transient long phone=999;
    double fee;
    static double totalFee=1600.0;
    static String titleName="Singh";
    transient Address add= new Address();

    public Student(String name, String uname, String password, int sid, long phone, double fee){
        System.out.println("Student Constructor call..");
        this.sid = sid;
        this.name = name;
        this.uname = uname;
        this.password=password;
        this.phone=phone;
        this.fee=fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", phone=" + phone +
                ", fee=" + fee +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", titleName='" + titleName + '\'' +
                ", Add Info ='" + add + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
