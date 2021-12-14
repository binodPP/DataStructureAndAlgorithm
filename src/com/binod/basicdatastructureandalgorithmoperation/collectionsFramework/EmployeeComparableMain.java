package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparableMain {
    public static void main(String[] args) {
        Employee employee= new Employee(1,"Binod","binod@gmail.com","Bangalore");
        Employee employee1= new Employee(4,"BinodSingh","binod1@gmail.com","kolkata");
        Employee employee2= new Employee(3,"Amayra","binod2@gmail.com","Delhi");
        Employee employee3= new Employee(5,"Praful","binod3@gmail.com","Mumbai");

        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        System.out.println("Before Sort  : ");
        for (Employee employee4: employeeList) {
            System.out.println("Employee Id: "+employee4.getId()+"||"+"Employee name: "+employee4.getName()+"|| "+"Employee email id: "+employee4.getEmailID()+"|| "+"Employee location: "+employee4.getLocation());
        }
        Collections.sort(employeeList);

        System.out.println("After Sort  : ");
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee5=(Employee) employeeList.get(i);
            System.out.println("Employee Id: "+employee5.getId()+"||"+"Employee name: "+employee5.getName()+"|| "+"Employee email id: "+employee5.getEmailID()+"|| "+"Employee location: "+employee5.getLocation());
        }
    }
}
