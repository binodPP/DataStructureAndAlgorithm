package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.validator;

import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.annoation.GreaterThanZero;
import com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.customannotaion.annoation.NotEmpty;

import java.lang.reflect.Field;

public class PersonValidator {

    public static void validate(Object obj){
      Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(NotEmpty.class)){
                Object value = null;
                try {
                    value = field.get(obj);
                }catch (IllegalAccessException e) {
                    System.err.println("Error accessing field: " + field.getName());
                }

                if(value == null || value.toString().isEmpty()){
                    NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(annotation.message());
                }
            }

            if(field.isAnnotationPresent(GreaterThanZero.class)){
                int value = 0;
                try {
                    value = field.getInt(obj);
                }catch (IllegalAccessException e) {
                    System.err.println("Error accessing field: " + field.getName());
                }

                if(value <= 0){
                    GreaterThanZero annotation = field.getAnnotation(GreaterThanZero.class);
                    throw new IllegalArgumentException(annotation.message());
                }
            }
        }
    }
}
