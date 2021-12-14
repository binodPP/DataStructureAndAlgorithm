package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework;

public class Employee implements Comparable {
    int id;
    String name;
    String emailID;
    String location;

    public Employee(int id, String name, String emailID, String location) {
        super();
        this.id = id;
        this.name = name;
        this.emailID = emailID;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee=(Employee)o;
        return this.id < employee.id?-1:this.id> employee.id?1:0;
    }

}
