package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.EqualsAndHashCodeTest;

import java.util.HashSet;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setId(100);
        e2.setId(100);

        System.out.println(e1.equals(e2));	//true
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        HashSet<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);

        System.out.println(employees);
        System.out.println(employees.size());
    }
}
