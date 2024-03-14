package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GreaterThanZero {
    String message() default "Value must be greater than zero";
}
