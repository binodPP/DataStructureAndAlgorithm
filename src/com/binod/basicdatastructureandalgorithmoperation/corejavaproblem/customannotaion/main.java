package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion;

import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.service.Person;
import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.validator.PersonValidator;

public class main {
    public static void main(String[] args) {
        try {
            Person person = new Person("", 25);
            PersonValidator.validate(person);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }


        try {
            Person person1 = new Person("Binod", 0);
            PersonValidator.validate(person1);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}
