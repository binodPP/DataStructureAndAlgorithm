package com.binod.basicdatastructureandalgorithmoperation.array;

public class FindThePrimeNumber {
    public static void main(String[] args) {
        int[] array= new int[100];
        int count=0;
        int i;
        boolean isPrime;
        for(i=1; i <= array.length; i ++){

            isPrime=isPrime(i);
            if(isPrime && i!=1) {
                System.out.println(i);
            }


        }
    }

    public static boolean isPrime(int i){

        for(int j=2; j<=i/2; j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }
}
