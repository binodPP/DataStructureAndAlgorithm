package com.binod.basicdatastructureandalgorithmoperation;

public class JavaTester {

    public void checkAge(int age){
        if(age<18)
            throw new ArithmeticException("Not Eligible for voting");
        else
            System.out.println("Eligible for voting");
    }

    public static void main(String args[]){
        JavaTester obj = new JavaTester();
        //obj.checkAge(13);
        try
        {
            int i = 5;   //This statement throws NumberFormatException
            int b=i/0;
        }

        /*catch(Exception ex)
        {
            System.out.println("This block handles all exception types");
        }*/

        catch(ArithmeticException ex)
        {
            //Compile time error
            //This block becomes unreachable as
            //exception is already caught by above catch block
        }
        System.out.println("End Of Program");
    }
}
